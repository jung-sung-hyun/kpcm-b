package kp.cmsc.cmsc01.svc;

import java.util.Map;

import kp.cmsc.cmsc01.vo.Cmsc01010002Vo;
/**
 * @Project : 차세대 지급결제플랫폼구축사업
 * @Class : Cmsc01010000Dao
 * @Package : kp.cm.cmsc01.dao
 * @Description: 공통 Pilot 구현을 위한 Service 클레스 입니다.
 * @Author : 정성현
 * @Date : 2024년. 05월. 25일
 * @Version : 0.1
 */
public interface Cmsc01010002Svc {
    public Map<String, Object> select00(Cmsc01010002Vo inputVo) throws Exception ;
    public Map<String, Object>  delete00(Cmsc01010002Vo inputVo) throws Exception ;
}