package kp.cmsc.cmsc01.ctr;

import java.util.Map;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Tag(name = "Cmsc01020000Ctr", description = "사용자의 로그인정보르 관리한다.")
@RestController
@WebAppConfiguration
@RequestMapping("/cm/cmsc01020000")
@Slf4j
public class Cmsc01020000Ctr {

    @Resource
    private Cmsc01020000Svc cmsc01020000Svc;
    /**
     * @Discription 1. 사용자 로그인을 처리한다.
     * @Author: 정성현
     * @param : Cmsc01020000Vo vo
     * @Date : 2024-07-07
     * @return: ResponseEntity
     * @throws Exception
     */
    @Operation(
            summary = "사용자 로그인",
            description = "사용자 로그인을 처리한다.",
            parameters = {
                    @Parameter(name= "swagConnect",description= "swagger 접속여부플레그",example = "Y"),
                    @Parameter(name= "mbrEmlAddr",description= "회원이메일주소", required = true),
                    @Parameter(name= "userPswd"      ,description= "비밀번호", required = true  )
            }
     )
    @ResponseBody
    @PostMapping(value = "/select00")
    //ResponseEntity<UserPageRes>
        public Map<String, Object> select00(  @RequestBody Cmsc01020000Vo inputVo, @ParameterObject Cmsc01020000Vo  inputParamVo) throws Exception{
        // public Map<String, Object> select00(@RequestBody  Cmsc01020000Vo inputVo) throws Exception{
            //        public Map<String, Object> select00(@ParameterObject Cmsc01020000Vo inputVo) throws Exception{
    //public Map<String, Object> select00(@RequestBody @ParameterObject Map<String, Object> inputVo) throws Exception{
//        if(inputParamVo != null) {
//            inputVo = inputParamVo;
//        }
       //log.info("inputParamVo======================>> : {}", inputParamVo);
       log.info("inputVo======================>> : {}", inputVo);

       return cmsc01020000Svc.select00(inputVo);
    }
    /**
     * @Discription 1. 사용자 인증정보를 삭제한다.
     * @Author: 정성현
     * @param : Cmsc01020000Vo vo
     * @Date : 2024-07-07
     * @return: ModelAndView
     * @throws Exception
     */
    @Operation(
            summary = "사용자 인증삭제",
            description = "사용자 인증정보를 삭제한다.",
            parameters = {},
            responses = {
                    @ApiResponse(responseCode = "200", description = "조회된 사용자 정보를 반환함.") ,
                    @ApiResponse(responseCode = "401", description = "인증되지 않은 사용자는 권한없음을 반환함.")
            }
     )
    @ResponseBody
    @PostMapping(value = "/delete00")
    public Map<String, Object>  delete00(@RequestBody Cmsc01020000Vo inputVo) throws Exception {
        return cmsc01020000Svc.delete00(inputVo);
    }
}
