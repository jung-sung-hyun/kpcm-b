package kp.cmsc.cmsc00.ctr;

import kp.cmsc.common.config.KnwpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
/**
 * @Project : 차세대 지급결제플랫폼구축사업
 * @Class : Cmsc00000000Ctr
 * @Package : kp.cm.cm01.ctr
 * @Description: 공통 Pilot 구현을 위한 클레스입니다.
 * @Author : 정성현
 * @Date : 2024년. 05월. 25일
 * @Version : 0.1 변경이 있을 때에는 수정 이력에 변경일자와 변경자, 그리고 변경사유를 기록하여 관리가 되도록 한다.
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
public class Cmsc00000000Ctr {
    @Autowired
    KnwpProperties knwpProperties;

    /**
     * @Discription
     * 1. 개요
     *  루트
     * 2. 주요처리로직
     *  루트
     * 3. 예외처리
     *  Exception 처리.
     * @Author: 정성현
     * @param : Cmsc00000000Vo vo
     * @Date : 2024-06-11
     * @return: ModelAndView
     * @throws Exception
     */
    @RequestMapping(value = "/")
    public ResponseEntity<?> healthCheck() throws Exception {
        Map<String, Object> response = new HashMap<>();
        response.put("response", "ok");
        response.put("code", 200);
        return ResponseEntity.ok(response);
    }

}
