package kp.cmsc.cmsc99.ctr;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Resource;
import kp.cmsc.cmsc99.svc.Cmsc99010000Svc;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/cm/cmsc99010000")
@Slf4j
public class Cmsc99010000Ctr {

    @Resource
    private Cmsc99010000Svc cmsc99010000Svr;

    private String uploadPath = "C:\\Temp\\"; // TODO 업로드 정책 결정 후 설정 파일로 옮겨야함

    /**
     * @param : MultipartFile
     * @throws Exception
     * @Discription 1. 아미지를 업로드한다.
     * @Author: 전인석
     * @Date : 2024-06-18
     * @return: ResponseEntity
     */
    @Operation(
            summary = "이미지 업로드",
            description = "이미지를 업로드한다.",
            parameters = {
                    @Parameter(name = "swagConnect", description = "swagger 접속여부 플래그", example = "Y"),
            }
    )
    @PostMapping("/uploadFile")
    public ResponseEntity<?> upload(@RequestPart (value = "file") MultipartFile multipartFile) throws Exception {

        log.debug("uploadFile start");

        Map<String, String> fileMap = cmsc99010000Svr.uploadFile(multipartFile);
        String uploadId = fileMap.get("fileId");

        Map<String, Object> response = new HashMap<>();
        response.put("response", "ok");
        response.put("code", 200);
        response.put("url", uploadId);

        return ResponseEntity.ok(response);
    }

    /**
     * @param : String
     * @throws Exception
     * @Discription 1. 아미지를 다운로드한다.
     * @Author: 전인석
     * @Date : 2024-06-18
     * @return: ResponseEntity
     */
    @Operation(
            summary = "이미지 다운로드",
            description = "이미지를 다운로드한다.",
            parameters = {
                    @Parameter(name = "swagConnect", description = "swagger 접속여부 플래그", example = "Y"),
            }
    )
    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<?> download(@PathVariable("fileId") String fileId) throws Exception {

        log.debug("downloadFile start");

        String saveFileName = fileId; // TODO : temp
        String originalFileName = fileId; // TODO : temp

//            UrlResource resource = new UrlResource("file:" + getFullPath(saveFileName));
        UrlResource resource = new UrlResource("file:" + uploadPath + saveFileName);

        log.info("saveFileName={}", saveFileName);

        String encodedOriginalFileName = UriUtils.encode(originalFileName, StandardCharsets.UTF_8);
        String contentDisposition = "attachment; filename=\"" + encodedOriginalFileName + "\"";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource);
    }

}