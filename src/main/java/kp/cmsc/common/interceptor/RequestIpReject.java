package kp.cmsc.common.interceptor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class RequestIpReject {
    private final JdbcTemplate jdbcTemplate;

    public RequestIpReject(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  boolean selecdtRequestIpReject(String ipAddr) {
        String sql = "SELECT ACS_IP_ADDR FROM SC_IP_ACS_CNTRL_B WHERE ACS_IP_ADDR = ? AND ACS_PSBLTY_YN = 'Y'";

        List<String> list = jdbcTemplate.query(sql, new Object[]{ipAddr}, new IpAddrRowMapper());
        if(list == null || list.size() <= 0) {
            return true;
        }

        return false;
    }

    private static class IpAddrRowMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getString("ACS_IP_ADDR"); // 정확한 컬럼 이름 사용
        }
    }
}
