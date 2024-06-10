/**
 *
 */
package kp.cmsc.cmsc01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kp.cmsc.cmsc01.vo.Cmsc01020000Vo;

/**
 * @Project : 차세대 지급결제플랫폼구축사업
 * @Class : Cmsc01010000Dao
 * @Package : kp.cm.cm01.dao
 * @Description: 공통 Pilot 구현을 위한 DataObject 클레스 입니다.
 * @Author : 정성현
 * @Date : 2024년. 05월. 25일
 * @Version : 0.1
 */
@Repository
@Mapper
public interface Cmsc01020000Dao {
    public Cmsc01020000Vo select00(Cmsc01020000Vo vo) throws Exception;
}
