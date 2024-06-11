package kp.cmsc.cmsc01.ctr;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import kp.cmsc.cmsc01.svc.Cmsc01020000Svc;
import kp.cmsc.cmsc01.vo.Cmsc01020000Vo;
import lombok.extern.slf4j.Slf4j;
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
     * @return: ModelAndView
     * @throws Exception
     */
    @SuppressWarnings("resource")
    @ResponseBody
    @RequestMapping(value = "/select00", method = RequestMethod.POST)
    public ResponseEntity<?>  select00(@RequestBody Cmsc01020000Vo inputVo) throws Exception {
        return ResponseEntity.ok(cmsc01020000Svc.select00(inputVo));
    }
    /**
     * @Discription 1. 사용자 인증정보를 삭제한다.
     * @Author: 정성현
     * @param : Cmsc01020000Vo vo
     * @Date : 2024-07-07
     * @return: ModelAndView
     * @throws Exception
     */
    @SuppressWarnings("resource")
    @ResponseBody
    @RequestMapping(value = "/delete00", method = RequestMethod.POST)
    public ResponseEntity<?>  delete00(@RequestBody Cmsc01020000Vo inputVo) throws Exception {
        return ResponseEntity.ok(cmsc01020000Svc.delete00(inputVo));
    }
}
