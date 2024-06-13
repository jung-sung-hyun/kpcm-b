package kp.cmsc.cmsc01.ctr;

import java.util.Map;

import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import kp.cmsc.cmsc01.svc.Cmsc01030000Svc;
import kp.cmsc.cmsc01.vo.Cmsc01030000Vo;
@RestController
@WebAppConfiguration
@RequestMapping("/cm/cmsc01030000")
@Tag(name = "Cmsc01030000Ctr", description = "메뉴리스트를 조회한다.")
public class Cmsc01030000Ctr {
    @Resource
    private Cmsc01030000Svc cmsc01030000Svc;
    /**
     * @Discription 1. 권한별로 메뉴리스트를 조회한다.
     * @Author: 정성현
     * @param : Cmsc01010000Vo vo
     * @Date : 2024-07-07
     * @return: ModelAndView
     * @throws Exception
     */
    @Operation(
        summary = "메뉴리스트 조회",
        description = "권한별로 메뉴리스트를 조회한다.",
        parameters = {},
        responses = {
                @ApiResponse(responseCode = "200", description = "권한별로 조회된 메뉴정보를 반환함.") ,
                @ApiResponse(responseCode = "401", description = "인증되지 않은 사용자는 권한없음을 반환함.")
        }
    )
        @ResponseBody
    @RequestMapping(value = "/selectList00", method = RequestMethod.POST)
    public Map<String, Object> selectList00(@RequestBody Cmsc01030000Vo vo) throws Exception {
        return cmsc01030000Svc.selectList00(vo);
    }

}
