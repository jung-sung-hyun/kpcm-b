package kp.cmsc.cmsc01.svc.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kp.cmsc.cmsc01.dao.Cmsc01010001Dao;
import kp.cmsc.cmsc01.svc.Cmsc01010001Svc;
import kp.cmsc.cmsc01.vo.Cmsc01010000Vo;
import kp.cmsc.cmsc01.vo.Cmsc01010001Vo;
import kp.cmsc.common.parameters.ReturnParam;

@Service
public class Cmsc01010001SvcImpl implements Cmsc01010001Svc {
    @Autowired
    Cmsc01010001Dao cmsc01010001Dao;
    Cmsc01010001Vo cmsc01010001Vo;
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
    public Map<String, Object> insert00(Cmsc01010001Vo inputVo) throws Exception {
        cmsc01010001Dao.insert00(inputVo);
        return  ReturnParam.pushParamAction(inputVo);
    }
}
