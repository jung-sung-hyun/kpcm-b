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
import kp.cmsc.common.util.MessageUtil;
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
     * @Discription 1. 개요 메소드에 대한 간단한 개요 기능등을 기술한다. 2. 주요처리로직 메소드에 대한 주요 처리 로직등을 기술
     *              한다. 3. 예외처리 예외처리시 전처리 후처리등의 내용을 기술 한다.
     * @Author: 홍길동
     * @param : Cmsc01010000Vo vo
     * @Date : 2024-01-07.13
     * @return: ModelAndView
     * @throws Exception
     */
    @Override
    public Map<String, Object> select00(Cmsc01020000Vo inPutVo) throws Exception{
      Cmsc01020000Vo userSelectVo = new Cmsc01020000Vo();

      try {
        String sHashCode = SecurityUtil.encryptToBase64(inPutVo.getMbrEmlAddr(), "SHA3-512");
        String sPwd = SecurityUtil.encryptToBase64(inPutVo.getUserPswd(), "SHA3-512");
        inPutVo.setUserPswd(sPwd);
          userSelectVo = Cmsc01020000Dao.select00(inPutVo);
          GlobalVariables.connectionHashCode = sHashCode;
          if(userSelectVo == null) {
                throw new KnwpException(MessageUtil.getMessage("CMSC0002"));
          }else {
              log.debug("======================getJedisPath==>>>:{}",knwpProperties.getJedisPath());
            JedisConnectSetParameter.setUserAuthInfo(knwpProperties,sHashCode, new StringBuffer()
                .append(userSelectVo.getAuthrtIdS())
                .append("&&")
                .append(userSelectVo.getMbrEmlAddr())
                .append("&&")
                .append(userSelectVo.getMbrNm())
                .toString());
          }
      } catch (KnwpException e) {
         log.error("=================error>>>:{}",e.toString());
         return ReturnParam.pushErrorAction("CMSC0002");
      }
      log.debug("==========================>>return parameter+===:::{}",ReturnParam.pushParamAction(inPutVo, userSelectVo));
      return ReturnParam.pushParamAction(inPutVo, userSelectVo);

    }


}
