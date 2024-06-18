package kp.cmsc.common.interceptor;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kp.cmsc.common.util.JsonUtil;
import kp.cmsc.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class LoggerInterceptor implements HandlerInterceptor {


    @Autowired
    private RequestInputParamSetJdbc requestInputParamSetJdbc;

    @Autowired
    private RequestIpReject requestIpReject;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    private final ObjectMapper objectMapper;

    public LoggerInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//          log.info("Request URL: {}, Method: {}", request.getRequestURL(), request.getMethod());
//          log.info("===================request.getMethod()==========================");
//          log.info(request.getMethod());
//          log.info("==========================request.getMethod()===================");
            //request.getSession().setAttribute("sessionIp", "127.0.0.1");

        if (!(request instanceof ContentCachingRequestWrapper)) {
            request = new ContentCachingRequestWrapper(request);
        }
        if (!(response instanceof ContentCachingResponseWrapper)) {
            response = new ContentCachingResponseWrapper(response);
        }

        String ipAddr = getLocalAddress().toString().replace("/", "");
        log.info("==================ipAddr==>>>",ipAddr);
        // bindIpAddressToMyBatis(request);
//      String ipAddr =  LocalIpAddressUtil.getClientIP(cachingRequest);
      boolean ipRejectFlg = requestIpReject.selecdtRequestIpReject(ipAddr);
      log.info("==================preHandle==============ipRejectFlg>>>:{}",ipRejectFlg);
      // TODO - ip 접근제어 일시 허용 추후 적용해야함
      /*
      if(ipRejectFlg) {
          //response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
//          Map<String, String> dataMap = (Map<String, String>) request.getAttribute("dataMap");
//          log.info("=====================dataMap>>:{}",dataMap);
//          request.setAttribute("dataMap", ReturnParam.pushErrorAction("CMSC0003"));
//          request.setAttribute("errCode"   , "CMSC0003");
//          request.setAttribute("errMessage", "시스템 접근권한이 없습니다.!");
          response.getWriter().write("Access Denied"); // Write some response to the client
          response.setStatus(HttpServletResponse.SC_FORBIDDEN); // Set appropriate status code


          return false;
       */
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        //log.info("======================request{}"+request.getAttributeNames());

        // 요청 객체에 설정된 모든 속성의 이름을 열거
//        Enumeration<String> attributeNames = request.getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            String attributeName = attributeNames.nextElement();
//            Object attributeValue = request.getAttribute(attributeName);
//            System.out.println("Attribute Name: " + attributeName + ", Value: " + attributeValue);
//        }

        log.info("Response Status: {}", response.getStatus());



    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
        if (ex != null) {
            log.error("Exception during request processing: {}", ex.getMessage());
        }

        if (request instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper cachingRequest = (ContentCachingRequestWrapper) request;
            // 캐시된 요청 본문 데이터 읽기
            byte[] cachedRequestBody = cachingRequest.getContentAsByteArray();
            String requestBody = new String(cachedRequestBody, request.getCharacterEncoding());
            //byte[] requestBody = cachingRequest.getContentAsByteArray();
            String ipAddr = getLocalAddress().toString().replace("/", "");
//            String ipAddr =  LocalIpAddressUtil.getClientIP(cachingRequest);
            boolean ipRejectFlg = requestIpReject.selecdtRequestIpReject(ipAddr);
log.info("==================afterCompletion==============ipRejectFlg>>>:{}",ipRejectFlg);
            String reqURL = cachingRequest.getRequestURL().toString();
            int resStatus = response.getStatus();
            String macAddr = macAddressGetNetwork();
            StringBuffer sbHeder = new StringBuffer();
            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String headerName = headerNames.nextElement();
                    String headerValue = request.getHeader(headerName);
                    sbHeder.append(headerName);
                    sbHeder.append(" = ");
                    sbHeder.append(headerValue);
                    sbHeder.append("\n"); // 줄 바꿈 추가
                    log.info("Header: {} = {}", headerName, headerValue);
                }
            }
            log.info("==============requestBody========start=====================");
            log.info(requestBody);
            Map<String, Object> listMap = JsonUtil.parseJsonToMap(requestBody);
            log.info("=================requestBody============end============>>{}",listMap);
            if(!"".equals(StringUtil.checkNull(requestBody))) {
                requestInputParamSetJdbc.insertRequestInputData(ipAddr,requestBody.toString(),StringUtil.checkNull(resStatus), sbHeder.toString(),reqURL,macAddr);
            }
//            public void insertRequestInputData(String ipAddr, String requestBody, String resStatus, String sbHeder, String reqURL) {
        }

        log.info("Request completed");
    }
    /**
     * request 파라미터 추가하기
     * @param request
     * @param paramName
     * @param paramValue
     * @return
     */
    public String buildUrlWithParameter(HttpServletRequest request, String paramName, String paramValue) {
        StringBuffer url = request.getRequestURL();

        // URL에 이미 쿼리 파라미터가 있는지 확인
        String queryString = request.getQueryString();
        if (queryString == null || queryString.isEmpty()) {
            url.append("?"); // 쿼리 시작
        } else {
            url.append("&"); // 추가 파라미터
        }

        // 새 파라미터 추가
        url.append(paramName).append("=").append(paramValue);

        return url.toString();
    }


    public static String getHostAddress() {
        InetAddress localAddress = getLocalAddress();
        if (localAddress == null) {
            try {
                return Inet4Address.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                ;
            }
        } else {
            return localAddress.getHostAddress();
        }
        return "";
    }

    private static InetAddress getLocalAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                List<InterfaceAddress> interfaceAddresses = networkInterfaces.nextElement().getInterfaceAddresses();
                for (InterfaceAddress interfaceAddress : interfaceAddresses) {
                    InetAddress address =interfaceAddress.getAddress();
                    if (address.isSiteLocalAddress()) {
                        return address;
                    }
                }
            }
        } catch (Exception e) {
            ;
        }
        return null;
    }

    public String  macAddressGetNetwork() throws SocketException {
        // 모든 네트워크 인터페이스를 열거
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        String macAddr = "";
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();

            // 하드웨어 주소 (MAC 주소) 가져오기
            byte[] mac = networkInterface.getHardwareAddress();

            if (mac != null) {
                log.info("Interface: " + networkInterface.getDisplayName() + " - MAC Address: ");

                // MAC 주소를 16진수 문자열로 변환하여 출력
                StringBuilder macAddress = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                macAddr = macAddress.toString();
                if(!"".equals(StringUtil.checkNull(macAddr))) {
                    break;
                }
                log.info("=========================macAddr:===>>:{}",macAddr);
            }
        }
        return macAddr;
    }

    // private void bindIpAddressToMyBatis(HttpServletRequest request) {
    //     String sessionIp = request.getRemoteAddr();
    //     log.info("IP Address: {}", sessionIp);

    //     try (SqlSession session = sqlSessionFactory.openSession()) {
    //         session.insert("kp.cmsc.cmsc01.dao.Cmsc01020000Dao.select00", sessionIp);
    //         session.commit();
    //     } catch (Exception e) {
    //         log.error("Error while binding IP address to MyBatis", e);
    //     }
    // }


    // private void bindIpAddressToMyBatis(HttpServletRequest request) {
    //     String ipAddress = request.getRemoteAddr();
    //     log.info("IP Address: {}", ipAddress);

    //     try (SqlSession session = sqlSessionFactory.openSession()) {
    //         session.insert("kp.cmsc.common.mapper.MyBatisMapper.insertIpAddress", ipAddress);
    //         session.commit();

    //         List<Map<String, Object>> results = session.selectList("kp.cmsc.common.mapper.MyBatisMapper.selectAllIpAddresses", new TypeToken<Map<String, Object>>(){}.getType());
    //         for (Map<String, Object> result : results) {
    //             log.info("Result: {}", result);
    //         }
    //     } catch (Exception e) {
    //         log.error("Error while binding IP address to MyBatis", e);
    //     }
    // }


}
