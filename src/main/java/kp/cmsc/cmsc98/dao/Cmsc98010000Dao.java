/**
 *
 */
package kp.cmsc.cmsc98.dao;

import java.util.HashMap;
import java.util.List;

import kp.cmsc.cmsc01.vo.Cmsc01030000Vo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kp.cmsc.cmsc98.vo.Cmsc98010000Vo;

/**
 * @Project    : 차세대 지급결제플랫폼구축사업
 * @Class      : Cm9801Dao
 * @Package    : kp.cm.cm01.dao
 * @Description: 공통 Pilot 구현을 위한 DataObject 클레스 입니다.
 * @Author     : 정성현
 * @Date       : 2024년. 05월. 25일
 * @Version    : 0.1
 */
@Repository
@Mapper
public interface Cmsc98010000Dao {
    public List<Cmsc98010000Vo> selectErrCdList(Cmsc98010000Vo vo)  throws Exception;
    public int insertErrCd(Cmsc98010000Vo vo) throws Exception ;
    public int updateErrCd(Cmsc98010000Vo vo) throws Exception ;
}
