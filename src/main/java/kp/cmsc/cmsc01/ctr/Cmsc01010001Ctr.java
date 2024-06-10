package kp.cmsc.cmsc01.ctr;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import kp.cmsc.cmsc01.svc.Cmsc01010001Svc;
import kp.cmsc.cmsc01.vo.Cmsc01010000Vo;
import kp.cmsc.common.config.KnwpProperties;
import kp.cmsc.common.util.JsonUtil;

/**
 * @Project : 차세대 지급결제플랫폼구축사업
 * @Class : Cmsc01010001Svc
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
@RequestMapping("/cm/cmsc01010001")
public class Cmsc01010001Ctr {
    @Resource
    private Cmsc01010001Svc cmsc01010001Svc;
    @Autowired
    KnwpProperties knwpProperties;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Cmsc01010001Ctr.class);
    /**
     * @Discription
     * 1. 개요
     *  게시판 신규
     * 2. 주요처리로직
     *  게시판의 신규 내용을 저장한다.
     * 3. 예외처리
     *  Exception 처리.
     * @Author: 홍길동
     * @param : Cmsc01010000Vo vo
     * @Date : 2024-07-07
     * @return: ModelAndView
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/insert00", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public ResponseEntity<Map<String, Object>>  insert00(@RequestBody HashMap<String, Object> map) throws Exception {
        Cmsc01010000Vo vo = new Cmsc01010000Vo();
        vo = (Cmsc01010000Vo) JsonUtil.getInstance().convertMapToObject(map, vo);
        Map<String, Object> responseMap = new HashMap<>();
        cmsc01010001Svc.insert00(vo);
        responseMap.put("message", "성공!!");
        return ResponseEntity.ok(responseMap);
    }

}
