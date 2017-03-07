package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by beznisco on 27.01.2017.
 */
public class ConnectionToDB {

    public boolean putData(String id, String title, String price) {
        Properties properties = new Properties();
        InputStream in = getClass().getClassLoader().getResourceAsStream("connectionToDB.properties");
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("dbUrl");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        String sqlStr = "INSERT INTO top_sale (id, phone_name, price)" + "VALUES (" + id + ", '" + title + "', '" + price + "');";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();
            st.executeUpdate(sqlStr);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
