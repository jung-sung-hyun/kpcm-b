package kp.cmsc.cmsc01.ctr;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.annotation.Resource;
import kp.cmsc.cmsc01.svc.Cmsc01010002Svc;
import kp.cmsc.cmsc01.vo.Cmsc01010002Vo;
import kp.cmsc.common.config.KnwpProperties;
import kp.cmsc.common.util.JsonUtil;

/**
 * @Project : 차세대 지급결제플랫폼구축사업
 * @Class : Cmsc01010002Svc
 * @Package : kp.cm.cmsc01.ctr
 * @Description: 게시판 상세조회 공통 Pilot 구현을 위한 클레스입니다.
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
@RequestMapping("/cm/cmsc01010002")
public class Cmsc01010002Ctr {
    @Resource
    private Cmsc01010002Svc cmsc01010002Svc;
    @Autowired
    KnwpProperties knwpProperties;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Cmsc01010002Ctr.class);
    /**
     * @Discription 게시판 리스테에서 조회한 결과 게시물을 선택했을때 상세 데이터를 조회한다.
     * @Author: 정성현
     * @param : Cmsc01010000Vo vo
     * @Date : 2024-07-07
     * @return: ModelAndView
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/select00", method = RequestMethod.POST)

    public ResponseEntity<Map<String, Object>> select00(@RequestBody Map<String, Object> map) throws Exception {
        Cmsc01010002Vo vo = new Cmsc01010002Vo();
        vo = (Cmsc01010002Vo) JsonUtil.getInstance().convertMapToObject(map, vo);
        Cmsc01010002Vo AllList = cmsc01010002Svc.select00(vo);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("Alllist", AllList);
        return ResponseEntity.ok(responseMap);
    }

    /**
     * @Discription 1. 게시판을 삭제하는 기능을 제공한다.
     * @Author: 홍길동
     * @param : Cmsc01010000Vo vo
     * @Date : 2024-07-07
     * @return: ModelAndView
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/delete00", method = RequestMethod.POST)
    public ModelAndView delete00(@RequestBody HashMap<String, Object> map) throws Exception {
        Cmsc01010002Vo vo = new Cmsc01010002Vo();
        vo = (Cmsc01010002Vo) JsonUtil.getInstance().convertMapToObject(map, vo);
        ModelAndView mav = new ModelAndView("jsonView");
        cmsc01010002Svc.delete00(vo);
        mav.addObject("message", "delete 성공!!");
        mav.setViewName("jsonView");
        return mav;
    }

}