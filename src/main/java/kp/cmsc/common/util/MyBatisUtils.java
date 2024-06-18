package kp.cmsc.common.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        MyBatisUtils.sqlSessionFactory = sqlSessionFactory;
    }

    public static <T> T getMapper(Class<T> type) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(type);
        }
    }
}