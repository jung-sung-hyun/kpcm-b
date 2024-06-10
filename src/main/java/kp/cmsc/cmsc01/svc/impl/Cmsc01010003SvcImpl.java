package kp.cmsc.cmsc01.svc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kp.cmsc.cmsc01.dao.Cmsc01010003Dao;
import kp.cmsc.cmsc01.svc.Cmsc01010003Svc;
import kp.cmsc.cmsc01.vo.Cmsc01010003Vo;

@Service
public class Cmsc01010003SvcImpl implements Cmsc01010003Svc {
    @Autowired
    Cmsc01010003Dao cmsc01010003Dao;
    /**
     * @Discription 1. 리스트테서 조회된 항목을 선택으로 상세 게시판 내용을 수정업데이트 한다.
     * @Author: 홍길동
     * @param : Cmsc01010003Vo vo
     * @Date : 2024-01-07.13
     * @return: ModelAndView
     * @throws Exception
     */
    @Override
    public void update00(Cmsc01010003Vo vo) throws Exception {
        cmsc01010003Dao.update00(vo);
    }



}
