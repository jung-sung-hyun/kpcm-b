package kp.cmsc.common.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RequestInputParamSetJdbc {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertRequestInputData(String ipAddr, String requestBody, String resStatus, String sbHeder, String reqURL,String macAddr) {
        String sql = "INSERT INTO SC_EVENT_LOG_H (REQST_IP_ADDR, REQST_BODY, REQST_STTS_NO, REQST_HEDR,REQST_USER_URL_ADDR,REQST_MAC_ADDR) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, ipAddr, requestBody, resStatus,sbHeder,reqURL, macAddr);
    }

}
