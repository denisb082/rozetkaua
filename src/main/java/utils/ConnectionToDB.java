package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by beznisco on 27.01.2017.
 */
public class ConnectionToDB {

    private Connection connection;
    public void putData(String id, String names, String prices) throws IOException {
        Properties properties = new Properties();
        InputStream in = getClass().getClassLoader().getResourceAsStream("connectionToDB.properties");
        properties.load(in);
        in.close();
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
        String sqlStr = "INSERT INTO top_sale (id, phone_name, price)" + "VALUES ("+id+", '"+names+"', '"+prices+"');";
        try {
            st.executeUpdate(sqlStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
