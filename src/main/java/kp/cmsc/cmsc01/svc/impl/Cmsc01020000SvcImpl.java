package kp.cmsc.cmsc01.svc.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kp.cmsc.cmsc01.dao.Cmsc01020000Dao;
import kp.cmsc.cmsc01.svc.Cmsc01020000Svc;
import kp.cmsc.cmsc01.vo.Cmsc01020000Vo;
import kp.cmsc.common.config.KnwpProperties;
import kp.cmsc.common.exception.KnwpException;
import kp.cmsc.common.parameters.GlobalVariables;
import kp.cmsc.common.parameters.JedisConnectSetParameter;
import kp.cmsc.common.parameters.ReturnParam;
import kp.cmsc.common.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class Cmsc01020000SvcImpl implements Cmsc01020000Svc {
    @Autowired
    Cmsc01020000Dao Cmsc01020000Dao;
    @Autowired
    KnwpProperties knwpProperties;
    /**
     * @Discription 1. 사용자의 로그인을 처리한다. 실폐 회수 5회 포함 인증 Hash 값 처리를 할수 있다.
     * @Author: 홍길동
     * @param : Cmsc01010000Vo vo
     * @Date : 2024-01-07.13
     * @return: ModelAndView
     * @throws Exception
     */
    @Override
    public Map<String, Object> select00(Cmsc01020000Vo inputVo) throws Exception{
      Cmsc01020000Vo userSelectVo = new Cmsc01020000Vo();

      try {
        String sHashCode = SecurityUtil.encryptToBase64(inputVo.getMbrEmlAddr(), "SHA3-512");
        String sPwd = SecurityUtil.encryptToBase64(inputVo.getUserPswd(), "SHA3-512");
        inputVo.setUserPswd(sPwd);
          userSelectVo = Cmsc01020000Dao.select00(inputVo);
          GlobalVariables.connectionHashCode = sHashCode;
          if(userSelectVo == null) {
                return ReturnParam.pushErrorAction("ERR.CM.0002");
          }else if("N".equals(userSelectVo.getRejTimeYn())){//비밀번호 오류
              return ReturnParam.pushErrorAction("ERR.CM.0005",5);
          }else if("N".equals(userSelectVo.getLoginYn())){//비밀번호 오류
              int iErrorCnt = userSelectVo.getLgnerrNocs()+1;
              userSelectVo.setLgnerrNocs(iErrorCnt+ 1);
              Cmsc01020000Dao.update00(userSelectVo);
              return ReturnParam.pushErrorAction("ERR.CM.0005",iErrorCnt);
          }else {
              log.debug("======================getJedisPath==>>>:{}",knwpProperties.getJedisPath());
            JedisConnectSetParameter.setUserAuthInfo(knwpProperties,sHashCode, new StringBuffer()
                .append(userSelectVo.getAuthrtIdS())
                .append("&&")
                .append(userSelectVo.getMbrEmlAddr())
                .append("&&")
                .append(userSelectVo.getMbrNm())
                .toString());
            userSelectVo.setLgnerrNocs(0);
            Cmsc01020000Dao.update00(userSelectVo);
          }
      } catch (KnwpException e) {
         log.error("=================error>>>:{}",e.toString());
         return ReturnParam.pushErrorAction("ERR.CM.0002");
      }
      log.debug("==========================>>return parameter+===:::{}",ReturnParam.pushParamAction(inputVo, userSelectVo));
      return ReturnParam.pushParamAction(inputVo, userSelectVo);

    }

    /**
     * @Discription 1. 사용자의 로그인을 처리한다. 실폐 회수 5회 포함 인증 Hash 값 처리를 할수 있다.
     * @Author: 홍길동
     * @param : Cmsc01010000Vo vo
     * @Date : 2024-01-07.13
     * @return: ModelAndView
     * @throws Exception
     */
    @Override
    public Map<String, Object> delete00(Cmsc01020000Vo inputVo) throws Exception{
        JedisConnectSetParameter.deleteUserAuthInfo(knwpProperties,inputVo.getConnectHash());
        Cmsc01020000Vo userSelectVo = new Cmsc01020000Vo();
        return ReturnParam.pushParamAction(inputVo, userSelectVo);
    }


}
