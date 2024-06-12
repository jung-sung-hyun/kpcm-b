package kp.cmsc.cmsc01.ctr;

import java.util.Map;

import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import kp.cmsc.cmsc01.svc.Cmsc01030000Svc;
import kp.cmsc.cmsc01.vo.Cmsc01030000Vo;
@RestController
@WebAppConfiguration
@RequestMapping("/cm/cmsc01030000")
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
    @ResponseBody
    @RequestMapping(value = "/selectList00", method = RequestMethod.POST)
    public Map<String, Object> selectList00(@RequestBody Cmsc01030000Vo vo) throws Exception {
        return cmsc01030000Svc.selectList00(vo);
    }

}
