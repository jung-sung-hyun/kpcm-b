package kp.cmsc.cmsc98.svc.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kp.cmsc.cmsc01.vo.Cmsc01030000Vo;
import kp.cmsc.common.exception.KnwpException;
import kp.cmsc.common.parameters.ReturnParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kp.cmsc.cmsc98.dao.Cmsc98010000Dao;
import kp.cmsc.cmsc98.svc.Cmsc98010000Svc;
import kp.cmsc.cmsc98.vo.Cmsc98010000Vo;

@Service
public class Cmsc98010000SvcImpl implements Cmsc98010000Svc {
    @Autowired
    Cmsc98010000Dao cmsc98010000Dao;

    /**
     * @param : Cmsc98010000Vo vo
     * @throws Exception
     * @Discription 1. 개요
     * 메소드에 대한 간단한 개요 기능등을 기술한다.
     * 2. 주요처리로직
     * 메소드에 대한 주요 처리 로직등을 기술 한다.
     * 3. 예외처리
     * 예외처리시 전처리 후처리등의 내용을 기술 한다.
     * @Author: 홍길동
     * @Date : 2024-01-07.13
     * @return: ModelAndView
     */
    @Override
    public Map<String, Object> selectErrCdList(Cmsc98010000Vo inputVo) throws Exception {
        List<Cmsc98010000Vo> outputVo = new ArrayList<Cmsc98010000Vo>();

        try {
            outputVo = cmsc98010000Dao.selectErrCdList(inputVo);
        } catch (KnwpException e) {
            return ReturnParam.pushErrorAction("ERR.CM.0002");
        }
        return ReturnParam.pushParamAction(inputVo, outputVo);
    }

    /**
     * @param : Cmsc98010000Vo vo
     * @throws Exception
     * @Discription 1. 개요
     * 메소드에 대한 간단한 개요 기능등을 기술한다.
     * 2. 주요처리로직
     * 메소드에 대한 주요 처리 로직등을 기술 한다.
     * 3. 예외처리
     * 예외처리시 전처리 후처리등의 내용을 기술 한다.
     * @Author: 홍길동
     * @Date : 2024-01-07.13
     * @return: ModelAndView
     */
    @Override
    public Map<String, Object> excuteErrCdList(Cmsc98010000Vo inputVo) throws Exception {
        List<Cmsc98010000Vo> outputVo = new ArrayList<>();

        try {
            int resultCnt = 0;
            // Insert 및 Update 처리
            for (int i = 0; i < inputVo.getList().size(); i++) {
                Cmsc98010000Vo vo = inputVo.getList().get(i);
                if ("추가".equals(vo.getRegStatus())) {
                    cmsc98010000Dao.insertErrCd(vo);
                    resultCnt += 1;
                } else if ("변경".equals(vo.getRegStatus())) {
                    cmsc98010000Dao.updateErrCd(vo);
                    resultCnt += 1;
                }
            }

            // 처리 후 전체 목록 조회
            outputVo = cmsc98010000Dao.selectErrCdList(inputVo);
        } catch (Exception e) {
            return ReturnParam.pushErrorAction("ERR.CM.0002");
        }
        return ReturnParam.pushParamAction(inputVo, outputVo);
    }
}