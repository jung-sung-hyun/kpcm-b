package kp.cmsc.cmsc01.ctr;

import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.annotation.Resource;
import kp.cmsc.cmsc01.svc.Cmsc01010003Svc;
import kp.cmsc.cmsc01.vo.Cmsc01010003Vo;
import kp.cmsc.common.config.KnwpProperties;
import kp.cmsc.common.util.JsonUtil;

/**
 * @Project : 차세대 지급결제플랫폼구축사업
 * @Class : Cmsc01010003Ctr
 * @Package : kp.cm.cm01.ctr
 * @Description: 공통 Pilot 구현을 위한 클레스입니다.
 * @Author : 정성현
 * @Date : 2024년. 05월. 25일
 * @Version : 0.1 변경이 있을 때에는 수정 이ㅣ력에 변경일자와 변경자, 그리고 변경사유를 기록하여 관리가 되도록 한다.
 *          ========================================================================================================
 *          수정 이력관리 (형상관리에도 Copy휴 반영)
 *          --------------------------------------------------------------------------------------------------------
 *          수정일 수정자 수정내용
 *          --------------------------------------------------------------------------------------------------------
 *          2024.05.15 정성현 최초작성 2024.05.16 홍길동 Method 수정및 추가작업
 *          ========================================================================================================
 */
@RestController
@WebAppConfiguration
@RequestMapping("/cm/cmsc01010003")
public class Cmsc01010003Ctr {
    @Resource
    private Cmsc01010003Svc cmsc01010003Svc;
    @Autowired
    KnwpProperties knwpProperties;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Cmsc01010003Ctr.class);

    /**
     * @Discription 1. 개요 메소드에 대한 간단한 개요 기능등을 기술한다. 2. 주요처리로직 메소드에 대한 주요 처리 로직등을 기술
     *              한다. 3. 예외처리 예외처리시 전처리 후처리등의 내용을 기술 한다.
     * @Author: 홍길동
     * @param : Cmsc01010000Vo vo
     * @Date : 2024-07-07
     * @return: ModelAndView
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update00", method = RequestMethod.POST)
    public ModelAndView update00(@RequestBody HashMap<String, Object> map) throws Exception {
        Cmsc01010003Vo vo = new Cmsc01010003Vo();
        vo = (Cmsc01010003Vo) JsonUtil.getInstance().convertMapToObject(map, vo);
        ModelAndView mav = new ModelAndView("jsonView");
        cmsc01010003Svc.update00(vo);
        mav.addObject("message", "update 성공!!");
        mav.setViewName("jsonView");
        return mav;
    }
}
