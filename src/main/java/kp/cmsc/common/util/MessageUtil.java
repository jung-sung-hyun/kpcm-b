package kp.cmsc.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class MessageUtil {
    private static final String DB_URL = "jdbc:log4jdbc:oracle:thin:@122.34.228.67:32771/xe?serverTimezone=UTC&characterEncoding=UTF8";
    private static final String DB_USER = "com";
    private static final String DB_PASSWORD = "com123";

    private static Map<String, String> messages = new HashMap<>();

    static {
        loadMessagesFromDB();
    }

    private static void loadMessagesFromDB() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT MSG_CD as key, MSG_CN as message FROM CM_MEG_CD_B");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                messages.put(resultSet.getString("key"), resultSet.getString("message"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getMessage(String key) {
        return messages.get(key);
    }
}

