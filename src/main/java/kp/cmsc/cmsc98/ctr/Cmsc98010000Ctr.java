package kp.cmsc.cmsc98.ctr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import kp.cmsc.cmsc01.vo.Cmsc01020000Vo;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
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
 * @Class      : Cm9801Ctr
 * @Package    : kp.cmsc.cmsc98.ctr
 * @Description: 공통 Pilot 구현을 위한 클래스입니다.
 * @Author     : 박대철
 * @Date       : 2024년. 06월. 14일
 * @Version    : 0.1
 * 변경이 있을 때에는 수정 이력에 변경일자와 변경자, 그리고 변경사유를 기록하여 관리가 되도록 한다.
 * ========================================================================================================
 *                                    수정 이력관리 (형상관리에도 Copy휴 반영)
 * --------------------------------------------------------------------------------------------------------
 *      수정일        수정자                                  수정내용
 * --------------------------------------------------------------------------------------------------------
 *   2024.06.13      박대철                                 최초작성
 * ========================================================================================================
 */
@RestController
@WebAppConfiguration
@RequestMapping("/cm/cmsc98010000")
@Slf4j
public class Cmsc98010000Ctr {

    @Resource
    private Cmsc98010000Svc cmsc98010000Svr;

    /**
     * @param : Cmsc98010000Vo
     * @throws Exception
     * @Discription 1. 오류메시지코드 관리 목록을 조회한다.
     * @Author: 박대철
     * @Date : 2024-06-07
     * @return: ResponseEntity
     */
    @Operation(
            summary = "오류메시지코드관리 목록조회",
            description = "오류메시지코드관리 목록을 조회한다.",
            parameters = {
                    @Parameter(name = "swagConnect", description = "swagger 접속여부 플래그", example = "Y"),
            }
    )
    @PostMapping(value = "/select00")
    public ResponseEntity<Map<String, Object>> selectErrCdList(@RequestBody Cmsc98010000Vo inputVo) throws Exception {
        log.info("inputVo======================>> : {}", inputVo);

        Map<String, Object> result;
        try {
            result = cmsc98010000Svr.selectErrCdList(inputVo);
        } catch (Exception e) {
            log.error("Error processing request", e);
            return ResponseEntity.status(500).body(Map.of("error", "Internal Server Error"));
        }

        return ResponseEntity.ok(result);
    }

    /**
     * @param : Cmsc98010000Vo
     * @throws Exception
     * @Discription 1. 오류메시지코드 관리 목록을 등록/수정한다.
     * @Author: 박대철
     * @Date : 2024-06-16
     * @return: ResponseEntity
     */
    @Operation(
            summary = "오류메시지코드관리 목록등록/수정",
            description = "오류메시지코드관리 목록을 등록/수정한다.",
            parameters = {
                    @Parameter(name = "swagConnect", description = "swagger 접속여부 플래그", example = "Y"),
            }
    )
    @PostMapping(value = "/exec00")
    public ResponseEntity<Map<String, Object>> excuteErrCdList(@RequestBody Cmsc98010000Vo inputVo) throws Exception {
        log.info("inputVo======================>> : {}", inputVo);

        Map<String, Object> result;
        try {
            result = cmsc98010000Svr.excuteErrCdList(inputVo);
        } catch (Exception e) {
            log.error("Error processing request", e);
            return ResponseEntity.status(500).body(Map.of("error", "Internal Server Error"));
        }

        return ResponseEntity.ok(result);
    }
}