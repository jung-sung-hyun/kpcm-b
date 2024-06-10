package kp.cmsc.cmsc01.ctr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import kp.cmsc.cmsc01.svc.Cmsc01010000Svc;
import kp.cmsc.cmsc01.vo.Cmsc01010000Vo;
import kp.cmsc.common.config.KnwpProperties;

/**
 * @Project : 차세대 지급결제플랫폼구축사업
 * @Class : Cmsc01010000Ctr
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
@RequestMapping("/cm/cmsc01010000")
public class Cmsc01010000Ctr {
    @Resource
    private Cmsc01010000Svc cmsc01010000Svc;
    @Autowired
    KnwpProperties knwpProperties;

    /**
     * @Discription
     * 1. 개요
     *  게시판 조회
     * 2. 주요처리로직
     *  게시판의 리스트 조회를 위해 조회한다.
     * 3. 예외처리
     *  Exception 처리.
     * @Author: 정성현
     * @param : Cmsc01010000Vo vo
     * @Date : 2024-07-07
     * @return: ModelAndView
     * @throws Exception
     */
    @RequestMapping(value = "/selectList00")
    public ResponseEntity<?>  selectBoardList(@RequestBody Cmsc01010000Vo vo) throws Exception {
        //System.out.println("knwpProperties:" + knwpProperties.getUploadPath());// 프로퍼티 테스트
        List<Cmsc01010000Vo> AllList = cmsc01010000Svc.selectList00();
        return ResponseEntity.ok(AllList);
    }

}
