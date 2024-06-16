package kp.cmsc.cmsc01.svc;

import java.util.Map;

import kp.cmsc.cmsc01.vo.Cmsc01010000Vo;
/**
 * @Project : 차세대 지급결제플랫폼구축사업
 * @Class : Cmsc01010000Svc
 * @Package : kp.cm.cmsc01.svc
 * @Description: 공통 Pilot 구현을 위한 Service 클레스 입니다.
 * @Author : 정성현
 * @Date : 2024년. 05월. 25일
 * @Version : 0.1
 */
public interface Cmsc01010000Svc {
    public Map<String, Object> selectList00(Cmsc01010000Vo inputVo) throws Exception ;

}