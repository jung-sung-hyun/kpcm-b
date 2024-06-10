package kp.cmsc.common.parameters;

import kp.cmsc.common.config.KnwpProperties;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
@Slf4j
public class JedisConnectSetParameter {

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
    public static String getUserAuthInfo(KnwpProperties knwpProperties,String hashCode) throws Exception {
        Jedis jedis = new Jedis(knwpProperties.getJedisPath(), knwpProperties.getJedisPort()); // Redis 서버의 호스트와 포트를 지정
        // 기본적인 연결 테스트
        String jedisPong = jedis.ping();
        if("PONG".equals(jedisPong)) {
log.info("==========================jedisPong>>>:{}",jedisPong);
            String sUuserInfo = jedis.get(hashCode);
            jedis.close();
            return sUuserInfo;
        }else {
            jedis.close();
            return "";
        }
    }
}
