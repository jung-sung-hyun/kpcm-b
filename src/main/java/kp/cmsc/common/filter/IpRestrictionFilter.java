//package kp.cmsc.common.filter;
//
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//public class IpRestrictionFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void destroy() {
//        // TODO Auto-generated method stub
//
//    }
////
////    private static final Set<String> allowedIps = new HashSet<>();
////
////    static {
////        // 허용할 IP 주소를 설정합니다.
////        allowedIps.add("192.168.1.100");
////        allowedIps.add("192.168.1.101");
////        // 다른 허용할 IP 주소 추가...
////    }
////
////    @Override
////    public void init(FilterConfig filterConfig) throws ServletException {
////        // 초기화 작업이 필요한 경우 여기서 수행합니다.
////    }
////
////    @Override
////    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
////            throws IOException, ServletException {
////
////        HttpServletRequest httpRequest = (HttpServletRequest) request;
////        HttpServletResponse httpResponse = (HttpServletResponse) response;
////
////        String remoteAddr = httpRequest.getRemoteAddr();
////
////        if (!allowedIps.contains(remoteAddr)) {
////            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden IP address");
////            return;
////        }
////
////        chain.doFilter(request, response);
////    }
////
////    @Override
////    public void destroy() {
////        // 정리 작업이 필요한 경우 여기서 수행합니다.
////    }
//}