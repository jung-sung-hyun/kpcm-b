package kp.cmsc.cmsc00.svc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kp.cmsc.cmsc00.dao.Cmsc00000000Dao;
import kp.cmsc.cmsc00.svc.Cmsc00000000Svc;
import kp.cmsc.cmsc00.vo.Cmsc00000000Vo;
import kp.cmsc.common.config.KnwpProperties;
import kp.cmsc.common.exception.KnwpException;
import kp.cmsc.common.parameters.JedisConnectSetParameter;
import kp.cmsc.common.parameters.ReturnParam;
import kp.cmsc.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Cmsc00000000SvcImpl implements Cmsc00000000Svc {
    @Autowired
    Cmsc00000000Dao cmsc00000000Dao;
    @Autowired
    KnwpProperties knwpProperties;

    /**
     * @Discription 버튼의 권한을 받아온다.
     * @Author: 홍길동
     * @param : Cmsc00000000Vo vo
     * @Date : 2024-01-07.13
     * @throws Exception
     */
    @Override
    public Map<String, Object>  selectList00(Cmsc00000000Vo inputVo) throws Exception {
        String userInfo = JedisConnectSetParameter.getUserAuthInfo(knwpProperties,inputVo.getConnectHash());
        log.debug(userInfo);
        List<Cmsc00000000Vo> outputVo = new ArrayList<Cmsc00000000Vo>();
        try {
            outputVo = cmsc00000000Dao.selectList00(inputVo,null);
            if(userInfo != null) {
                String[] aUserInfo = userInfo.split("&&");
                List<String> list = new ArrayList<>();
                if(aUserInfo.length > 0) {
                    log.debug(aUserInfo[0]);
                    String[] sAuthCd = aUserInfo[0].split(",");
                    list = (List<String>)JsonUtil.getInstance().convertMapToObject(sAuthCd, list);
                }
                outputVo = cmsc00000000Dao.selectList00(inputVo,list);
            }else {
                return ReturnParam.pushErrorAction("SYS.CM.0003");
            }
        } catch (KnwpException e) {
            return ReturnParam.pushErrorAction("ERR.CM.0002");
        }
        return ReturnParam.pushParamAction(inputVo, outputVo);
    }
}
