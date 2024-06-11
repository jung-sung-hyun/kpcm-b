package kp.cmsc.cmsc01.svc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kp.cmsc.cmsc01.dao.Cmsc01030000Dao;
import kp.cmsc.cmsc01.svc.Cmsc01030000Svc;
import kp.cmsc.cmsc01.vo.Cmsc01030000Vo;
import kp.cmsc.common.config.KnwpProperties;
import kp.cmsc.common.exception.KnwpException;
import kp.cmsc.common.parameters.JedisConnectSetParameter;
import kp.cmsc.common.parameters.ReturnParam;
import kp.cmsc.common.util.JsonUtil;
import kp.cmsc.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Cmsc01030000SvcImpl implements Cmsc01030000Svc {
    @Autowired
    Cmsc01030000Dao cmsc01030000Dao;
    @Autowired
    KnwpProperties knwpProperties;

    /**
     * @Discription 1. 권한별 메뉴를 조회한다.
     * @Author: 홍길동
     * @param : Cmsc01010000Vo vo
     * @Date : 2024-01-07.13
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object>  selectList00(Cmsc01030000Vo inputVo) throws Exception {

        log.info("=====================inputVo.getConnectHash()>:{}",inputVo.getConnectHash());
        String userInfo = JedisConnectSetParameter.getUserAuthInfo(knwpProperties,inputVo.getConnectHash());
        log.debug(userInfo);
        List<Cmsc01030000Vo> outputVo = new ArrayList<Cmsc01030000Vo>();
        try {
            if(userInfo != null) {
                String[] aUserInfo = userInfo.split("&&");
                List<String> list = new ArrayList<>();
                if(aUserInfo.length > 0) {
                    log.debug(aUserInfo[0]);
                    String[] sAuthCd = aUserInfo[0].split(",");
        //            List<HashMap<String, Object>> list = aUserInfo[0].split(",");
                    list = (List<String>)JsonUtil.getInstance().convertMapToObject(sAuthCd, list);
                }
                outputVo = cmsc01030000Dao.selectList00(inputVo,list);
                log.info("=====================generateCustomKey()>:{}",StringUtil.generateCustomKey());
            }else {
                return ReturnParam.pushErrorAction("SYS.CM.0003");
            }
        } catch (KnwpException e) {
            return ReturnParam.pushErrorAction("ERR.CM.0002");
        }
        return ReturnParam.pushParamAction(inputVo, outputVo);
    }
}
