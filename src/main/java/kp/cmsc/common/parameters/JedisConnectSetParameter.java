package kp.cmsc.common.parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kp.cmsc.common.config.KnwpProperties;
import kp.cmsc.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
@Slf4j
@Component
public class JedisConnectSetParameter {
    @Autowired
    static
    KnwpProperties appProperties;
    @Autowired
    KnwpProperties properties;

//    public List<Map<String, Object>> jedisConnection(KnwpProperties knwpPropertie,String json) throws Exception {
//
//        Jedis jedis = new Jedis(knwpProperties.getJedisPath(), knwpProperties.getJedisPort()); // Redis 서버의 호스트와 포트를 지정
//
//
//        jedis.close();
//
//        return null;
//
//    }
//
//    public static List<Map<String, Object>> getConnectHashCode(KnwpProperties knwpPropertie,String json) throws Exception {
//
//        Jedis jedis = new Jedis(knwpProperties.getJedisPath(), knwpProperties.getJedisPort()); // Redis 서버의 호스트와 포트를 지정
//        jedis.close();
//        return null;
//
//    }


    public static void setUserAuthInfo(KnwpProperties knwpProperties,String hashCode, String authParam) throws Exception {

        Jedis jedis = new Jedis(knwpProperties.getJedisPath(), knwpProperties.getJedisPort()); // Redis 서버의 호스트와 포트를 지정
        // 기본적인 연결 테스트
        String jedisPong = jedis.ping();
        log.debug("Response from Redis: :==============debugdebug====={}",jedisPong);
        if("PONG".equals(jedisPong)) {
            //데이터 읽기
            String sUserEmail = jedis.get(hashCode);
            log.debug("Response from Redis: :==============sUserEmail====={}",sUserEmail);
//          // 데이터 삭제
//          jedis.del("key");
//          System.out.println("Deleted key 'key'");

            jedis.set(hashCode, authParam);
            // TTL 설정
            jedis.expire(hashCode, 1*60); // 1분 동안 유효

        }
        jedis.close();
    }
    public void test() throws Exception{
        log.info("=============================jedisPath============================={}",properties.getJedisPath());
    }
    public static void deleteUserAuthInfo(KnwpProperties knwpProperties,String hashCode) throws Exception {

        Jedis jedis = new Jedis(knwpProperties.getJedisPath(), knwpProperties.getJedisPort()); // Redis 서버의 호스트와 포트를 지정
        // 기본적인 연결 테스트
        String jedisPong = jedis.ping();
        log.info("Response from Redis: :==============debugdebug====={}",jedisPong);
        if("PONG".equals(jedisPong)) {
            // 데이터 삭제
            jedis.del(hashCode);
        }
        jedis.close();
    }

    public static List<String> getUserAuthInfo(KnwpProperties knwpProperties,String hashCode) throws Exception {
        Jedis jedis = new Jedis(knwpProperties.getJedisPath(), knwpProperties.getJedisPort()); // Redis 서버의 호스트와 포트를 지정
        // 기본적인 연결 테스트
        String jedisPong = jedis.ping();
        log.info("==========================jedisPong>>>:{}",jedisPong);
        log.info("==========================hashCode>>>:{}",hashCode);
        if(hashCode != null && "PONG".equals(jedisPong)) {
            String sUuserInfo = jedis.get(hashCode);
            log.info("==========================sUuserInfo>>>:{}",sUuserInfo);
            Map<String,Object> map = JsonUtil.parseJsonToMap(sUuserInfo);
            String sAuth = map.get("auth").toString();
            List<String> list = new ArrayList<>();
            list.add(sAuth);
            log.info("===============================list=>>>>{}",list);
            jedis.close();
            return list;
        }else {
            jedis.close();
            return null;
        }
    }

    // public static List getUserAuthInfo(KnwpProperties knwpProperties,String hashCode) throws Exception {
    //     Jedis jedis = new Jedis(knwpProperties.getJedisPath(), knwpProperties.getJedisPort()); // Redis 서버의 호스트와 포트를 지정
    //     // 기본적인 연결 테스트
    //     String jedisPong = jedis.ping();
    //     log.info("==========================jedisPong>>>:{}",jedisPong);
    //     if(hashCode != null && "PONG".equals(jedisPong)) {
    //         String sUuserInfo = jedis.get(hashCode);
    //         jedis.close();
    //         return sUuserInfo;
    //     }else {
    //         jedis.close();
    //         return "";
    //     }
    // }
}
