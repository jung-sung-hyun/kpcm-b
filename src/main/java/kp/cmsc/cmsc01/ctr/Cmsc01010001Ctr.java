package kp.cmsc.cmsc01.ctr;

import java.util.Map;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import kp.cmsc.cmsc01.svc.Cmsc01010001Svc;
import kp.cmsc.cmsc01.vo.Cmsc01010001Vo;

@Tag(
        name       = "Cmsc01010001Ctr[관리자]게시판추가저장",
        description=  "===================================================================</br>"
                + " @Package    : kp.cmsc.cmsc01.ctr                  </br>"
                + " @Description: 공통 Pilot 구현을 위한 클레스입니다.</br>"
                + " @Author     : 정성현                              </br>"
                + " @Date       : 2024년. 05월. 25일                  </br>"
                + "===================================================================</br>"
)
@RestController
@WebAppConfiguration
@RequestMapping("/cm/cmsc01010001")
public class Cmsc01010001Ctr {
    @Resource
    private Cmsc01010001Svc cmsc01010001Svc;

    @Operation(
            summary = "[게시판추가저장]",
            description= "======================================================================================================================</br>"
                    + " @Package    : kp.cmsc.cmsc01.ctr                                                                                    </br>"
                    + " @Method     : insert00                                                                                              </br>"
                    + " @Description:                                                                                                       </br>"
                    + " @Description:                                                                                                       </br>"
                    + " - 게시판 추가로 입력하고 저장한다.                                                                                  </br>"
                    + " @HandlMainException:                                                                                                </br>"
                    + " - 특이사항없음                                                                                                      </br>"
                    + " @Author     : 정성현                                                                                                </br>"
                    + " @Date       : 2024년. 05월. 25일                                                                                    </br>"
                    + " @Version    : 0.1 변경이 있을 때에는 수정 이력에 변경일자와 변경자, 그리고 변경사유를 기록하여 관리가 되도록 한다.</br>"
                    + " @Update     :                                                                                                       </br>"
                    + "  - 2024.05.15 정성현 최초작성                                                                                       </br>"
                    + "  - 2024.05.16 홍길동 Method 수정및 추가작업                                                                         </br>"
                    + "=====================================================================================================================</br>",
            parameters = {
                    @Parameter(name= "title"   , description= "게시글타이틀-IN" , hidden= true,required = true),
                    @Parameter(name= "contents", description= "게시글내용-IN"   , hidden= true)
            },
            responses = {
                    @ApiResponse(responseCode = "200"        , description = "요청이 성공적으로 처리되었습니다.                                "),
                    @ApiResponse(responseCode = "201"        , description = "요청이 성공적으로 처리되어 새로운 리소스가 생성되었습니다.       "),
                    @ApiResponse(responseCode = "400"        , description = "잘못된 요청입니다. 요청 형식을 확인해주세요.                     "),
                    @ApiResponse(responseCode = "401"        , description = "인증되지 않은 요청입니다. 로그인이 필요합니다.                   "),
                    @ApiResponse(responseCode = "403"        , description = "접근이 거부되었습니다. 접근 권한을 확인해주세요."                 ),
                    @ApiResponse(responseCode = "404"        , description = "요청한 리소스를 찾을 수 없습니다.                                "),
                    @ApiResponse(responseCode = "500"        , description = "서버 내부 오류가 발생했습니다. 서버 관리자에게 문의하세요.       ")
            }
    )
    @ResponseBody
//    @PostMapping(value = "/insert00")
    @RequestMapping(value = "/insert00", method = RequestMethod.POST)
    public Map<String, Object> insert00(@RequestBody Cmsc01010001Vo inputVo , @ParameterObject Cmsc01010001Vo swaggerParam) throws Exception {
        return cmsc01010001Svc.insert00(inputVo);
    }

}
