package kp.cmsc.common.interceptor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class IpAddrRowMapper implements RowMapper<IpAddrVo> {
    @Override
    public IpAddrVo mapRow(ResultSet rs, int rowNum) throws SQLException {
        IpAddrVo ipAddrVo = new IpAddrVo();
        ipAddrVo.setSysSeCd(rs.getString("sysSeCd"));
        ipAddrVo.setAcsIpAddr(rs.getString("acsIpAddr"));
        ipAddrVo.setAcsPsbltyYn(rs.getString("acsPsbltyYn"));
        return ipAddrVo;
    }
}
