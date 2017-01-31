package utils;

import java.sql.*;
import java.util.Properties;

/**
 * Created by beznisco on 27.01.2017.
 */
public class ConnectionToDB {

    private Connection connection;
    public void putData(String id, String names, String prices){
        Properties properties = new Properties();
        String url = properties.getProperty("dbUrl");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Statement st = null;
        try {
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlStr = "INSERT INTO top_sale VALUES ("+id+", "+names+", "+prices+")";
        try {
            ResultSet resultSet = st.executeQuery(sqlStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
