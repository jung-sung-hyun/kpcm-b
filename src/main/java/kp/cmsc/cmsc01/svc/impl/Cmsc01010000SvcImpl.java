package kp.cmsc.cmsc01.svc.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kp.cmsc.cmsc01.dao.Cmsc01010000Dao;
import kp.cmsc.cmsc01.svc.Cmsc01010000Svc;
import kp.cmsc.cmsc01.vo.Cmsc01010000Vo;
import kp.cmsc.common.parameters.ReturnParam;

@Service
public class Cmsc01010000SvcImpl implements Cmsc01010000Svc {
    @Autowired
    Cmsc01010000Dao cmsc01010000Dao;
    /**
     * @Discription 1. 개요 메소드에 대한 간단한 개요 기능등을 기술한다. 2. 주요처리로직 메소드에 대한 주요 처리 로직등을 기술
     *              한다. 3. 예외처리 예외처리시 전처리 후처리등의 내용을 기술 한다.
     * @Author: 홍길동
     * @param : Cmsc01010000Vo inputVo
     * @Date : 2024-01-07.13
     * @return: Map<String, Object>
     * @throws Exception
     */
    @Override
    public Map<String, Object> selectList00(Cmsc01010000Vo inputVo) throws Exception {
        List<Cmsc01010000Vo> outputVo =  cmsc01010000Dao.selectList00(inputVo);
        return  ReturnParam.pushParamAction(inputVo,outputVo);
    }

}
