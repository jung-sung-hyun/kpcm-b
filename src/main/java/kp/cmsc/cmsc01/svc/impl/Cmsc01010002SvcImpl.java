package kp.cmsc.cmsc01.svc.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kp.cmsc.cmsc01.dao.Cmsc01010002Dao;
import kp.cmsc.cmsc01.svc.Cmsc01010002Svc;
import kp.cmsc.cmsc01.vo.Cmsc01010002Vo;
import kp.cmsc.common.parameters.ReturnParam;

@Service
public class Cmsc01010002SvcImpl implements Cmsc01010002Svc {
    @Autowired
    Cmsc01010002Dao cmsc01010002Dao;

    /**
     * @Discription 1. 리스트테서 조회된 항목을 선택으로 상세 게시판 내용을 조회 한다.
     * @Author: 홍길동
     * @param : Cmsc01010002Vo vo
     * @Date : 2024-01-07.13
     * @return: ModelAndView
     * @throws Exception
     */
    @Override
    public Map<String, Object> select00(Cmsc01010002Vo inputVo) throws Exception {
        Cmsc01010002Vo outputVo = cmsc01010002Dao.select00(inputVo);
        return  ReturnParam.pushParamAction(inputVo,outputVo);
    }
    /**
     * @Discription 1. 게시판 상세 조회된 내역을 삭제처리한다.
     * @Author: 홍길동
     * @param : Cmsc01010002Vo vo
     * @Date : 2024-01-07.13
     * @return: ModelAndView
     * @throws Exception
     */
    @Override
    public  Map<String, Object>  delete00(Cmsc01010002Vo inputVo) throws Exception {
        cmsc01010002Dao.delete00(inputVo);
        return  ReturnParam.pushParamAction(inputVo);
    }
}
