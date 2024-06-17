/**
 *
 */
package kp.cmsc.cmsc00.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kp.cmsc.cmsc00.vo.Cmsc00000000Vo;

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
public interface Cmsc00000000Dao {
    public List<Cmsc00000000Vo> selectList00(@Param("inputVo") Cmsc00000000Vo inputVo   ,@Param("idList") List<String> idList ) throws Exception;
}
