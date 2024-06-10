package kp.cmsc.cmsc98.ctr;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import kp.cmsc.cmsc98.svc.Cmsc98010000Svc;
import kp.cmsc.cmsc98.vo.Cmsc98010000Vo;
import kp.cmsc.common.config.KnwpProperties;
/**
 * @Project    : 차세대 지급결제플랫폼구축사업
 * @Class      : Cm0101Ctr
 * @Package    : kp.cmsc.cmsc98.ctr
 * @Description: 공통 Pilot 구현을 위한 클레스입니다.
 * @Author     : 박대철
 * @Date       : 2024년. 05월. 25일
 * @Version    : 0.1
 * 변경이 있을 때에는 수정 이ㅣ력에 변경일자와 변경자, 그리고 변경사유를 기록하여 관리가 되도록 한다.
 * ========================================================================================================
 *                                    수정 이력관리 (형상관리에도 Copy휴 반영)
 * --------------------------------------------------------------------------------------------------------
 *      수정일        수정자                                  수정내용
 * --------------------------------------------------------------------------------------------------------
 *   2024.05.15       박대철                                  최초작성
 *   2024.05.16       홍길동                     Method 수정및 추가작업
 * ========================================================================================================
 */
@RestController
@WebAppConfiguration
@RequestMapping("/cm/cmsc98010000")
public class Cmsc98010000Ctr {

    @Resource
    private Cmsc98010000Svc cmsc98010000Svr;
    @Autowired
    KnwpProperties knwpProperties;
    /**
     * @Discription
     * 1. 개요
     *  메소드에 대한 간단한 개요 기능등을 기술한다.
     * 2. 주요처리로직
     *  메소드에 대한 주요 처리 로직등을 기술 한다.
     * 3. 예외처리
     *  예외처리시 전처리 후처리등의 내용을 기술 한다.
     * @Author: 박대철
     * @param : Cm0101Vo vo
     * @Date  : 2024-07-07
     * @return: ModelAndView
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/selectList00")
    public ResponseEntity<List<Cmsc98010000Vo>> selectCommonCodeList(@RequestBody List<HashMap<String, Object>> list) throws Exception {
        System.out.println("param : " + list);
        System.out.println("knwpProperties:"+knwpProperties.getUploadPath());//프로퍼티 테스트
        Cmsc98010000Vo vo = new Cmsc98010000Vo();
        List<Cmsc98010000Vo> AllList = cmsc98010000Svr.selectCommonCodeList(list);

        return new ResponseEntity<>(AllList, HttpStatus.OK);
    }
}
