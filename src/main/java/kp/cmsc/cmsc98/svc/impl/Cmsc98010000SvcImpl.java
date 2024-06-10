package kp.cmsc.cmsc98.svc.impl;

import java.util.HashMap;
import java.util.List;

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
     * @Discription
     * 1. 개요
     *  메소드에 대한 간단한 개요 기능등을 기술한다.
     * 2. 주요처리로직
     *  메소드에 대한 주요 처리 로직등을 기술 한다.
     * 3. 예외처리
     *  예외처리시 전처리 후처리등의 내용을 기술 한다.
     * @Author: 홍길동
     * @param : Cmsc98010000Vo vo
     * @Date  : 2024-01-07.13
     * @return: ModelAndView
     * @throws Exception
     */

    @Override
    public List<Cmsc98010000Vo> selectCommonCodeList(List<HashMap<String, Object>> list) throws Exception {
        //List<Cm9801Vo> listParam = new ArrayList<>();
        if (list != null && list.size() > 0) {
            //for (int i = 0; i < list.size(); i++) {
                //listParam.add(cm9801Dao.selectCommonCodeOne(list.get(i)));
            //}
        }
        return cmsc98010000Dao.selectCommonCodeList(list);
    }

}
