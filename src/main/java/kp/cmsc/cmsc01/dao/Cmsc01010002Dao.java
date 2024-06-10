/**
 *
 */
package kp.cmsc.cmsc01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kp.cmsc.cmsc01.vo.Cmsc01010002Vo;
/**
 * @Project : 차세대 지급결제플랫폼구축사업
 * @Class : Cmsc01010002Dao
 * @Package : kp.cm.cmsc01.dao
 * @Description: 공통 Pilot 구현을 위한 DataObject 클레스 입니다.
 * @Author : 정성현
 * @Date : 2024년. 05월. 25일
 * @Version : 0.1
 */
@Repository
@Mapper
public interface Cmsc01010002Dao {
    public Cmsc01010002Vo select00(Cmsc01010002Vo vo) throws Exception;
    public void delete00(Cmsc01010002Vo vo) throws Exception;
}
