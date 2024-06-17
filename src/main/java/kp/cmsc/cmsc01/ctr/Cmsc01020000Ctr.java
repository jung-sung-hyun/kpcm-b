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
import kp.cmsc.cmsc01.svc.Cmsc01020000Svc;
import kp.cmsc.cmsc01.vo.Cmsc01020000Vo;
import lombok.extern.slf4j.Slf4j;


@RestController
@WebAppConfiguration
@RequestMapping("/cm/cmsc01020000")
@Tag(
        name       = "Cmsc01020000Ctr[관리자]로그인",
        description=  "==========================================================================</br>"
                + " @Package    : kp.cmsc.cmsc01.ctr                                             </br>"
                + " @Description: 사용자의 로그인정보를 관리한다.                                </br>"
                + "               로그인된 관리자에 대해 인증정보를 생성하고 인증정보를 반환한다.</br>"
                + " @Author     : 정성현                                                         </br>"
                + " @Date       : 2024년. 05월. 25일                                             </br>"
                + "==============================================================================</br>"
)
@Slf4j
public class Cmsc01020000Ctr {

    @Resource
    private Cmsc01020000Svc cmsc01020000Svc;

    @Operation(
            summary    = "[사용자 로그인]",
            description= "============================================================================================================= ====</br>"
                    + " @Package    : kp.cmsc.cmsc01.ctr                                                                                    </br>"
                    + " @Method     : select00                                                                                              </br>"
                    + " @Description:                                                                                                       </br>"
                    + " - 사용자 로그인을 처리한다.                                                                                         </br>"
                    + " @HandlMainException:                                                                                                </br>"
                    + " - 1.로그인 실폐시 횟수를 +1 하고 5회일때 더이상 5분간 로그인 할 수 없도록 처리한다.                                 </br>"
                    + " @Author     : 정성현                                                                                                </br>"
                    + " @Date       : 2024년. 05월. 25일                                                                                    </br>"
                    + " @Version    : 0.1 변경이 있을 때에는 수정 이력에 변경일자와 변경자, 그리고 변경사유를 기록하여 관리가 되도록 한다.  </br>"
                    + " @Update     :                                                                                                       </br>"
                    + "  - 2024.05.15 정성현 최초작성                                                                                       </br>"
                    + "  - 2024.05.16 홍길동 Method 수정및 추가작업                                                                         </br>"
                    + "=====================================================================================================================</br>",

            parameters = {
                    @Parameter(name= "mbrEmlAddr", description= "회원이메일주소-IN" , required = true ,hidden= true,example = "="),
                    @Parameter(name= "userPswd"  , description= "비밀번호-IN"     , required = true ,hidden= true,example = "=")
            },
            responses = {
                    @ApiResponse(responseCode = "ERR.CM.0002", description = "사용자정보가 잘못 되었습니다.                                    "),
                    @ApiResponse(responseCode = "ERR.CM.0005", description = "로그인횟수 %d회 실폐했습니다. 5회이상 실패시 로그인이 제한됩니다."),
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
    @RequestMapping(value = "/select00", method = RequestMethod.POST)
    public Map<String, Object> select00(  @RequestBody   Cmsc01020000Vo  inputVo ,@ParameterObject Cmsc01020000Vo swaggerParam) throws Exception{
        return cmsc01020000Svc.select00(inputVo);
    }
    @Operation(
            summary = "사용자 인증삭제",
            description= "==================================================== =============================================================</br>"
                    + " @Package    : kp.cmsc.cmsc01.ctr                                                                                    </br>"
                    + " @Method     : delete00                                                                                              </br>"
                    + " @Description:                                                                                                       </br>"
                    + " - 사용자 로그인시 취득한 인증정보를 삭제한다.                                                                       </br>"
                    + " @HandlMainException:                                                                                                </br>"
                    + " - 특이사항없음                                                                                                      </br>"
                    + " @Author     : 정성현                                                                                                </br>"
                    + " @Date       : 2024년. 05월. 25일                                                                                    </br>"
                    + " @Version    : 0.1 변경이 있을 때에는 수정 이력에 변경일자와 변경자, 그리고 변경사유를 기록하여 관리가 되도록 한다.  </br>"
                    + " @Update     :                                                                                                       </br>"
                    + "  - 2024.05.15 정성현 최초작성                                                                                       </br>"
                    + "  - 2024.05.16 홍길동 Method 수정및 추가작업                                                                         </br>"
                    + "=====================================================================================================================</br>",
            parameters = {
                    @Parameter(name= "connectHash", description= "사용자인증키-IN" , hidden= true,required = true)
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
    @RequestMapping(value = "/delete00", method = RequestMethod.POST)
    public Map<String, Object>  delete00(@RequestBody Cmsc01020000Vo inputVo, @ParameterObject Cmsc01020000Vo swaggerParam) throws Exception {
        return cmsc01020000Svc.delete00(inputVo);
    }
}
