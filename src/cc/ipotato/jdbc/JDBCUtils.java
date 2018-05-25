package cc.ipotato.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.Properties;

/**
 * Created by haohao on 2018/5/25.
 */
public class JDBCUtils {
    public static String DBDRIVER;
    public static String DBURL;
    public static String DBUSER;
    public static String DBPASS;
    static {
        try {
            readConfig();
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e + "数据库驱动注册失败!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e + "读取配置文件失败！");
        } catch (IOException e) {
            throw new RuntimeException(e + "加载配置文件失败！");
        }
    }

    private JDBCUtils(){}

    private static void readConfig() throws IOException{
        Properties properties = new Properties();
        Reader reader = new FileReader("db.properties");
        properties.load(reader);
        DBDRIVER = properties.getProperty("driver");
        DBURL = properties.getProperty("url");
        DBUSER = properties.getProperty("user");
        DBPASS = properties.getProperty("password");
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (SQLException e) {
            throw new RuntimeException(e + "获取数据库连接失败");
        }
    }


    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {}
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {}
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {}
        }
    }

    public static void close(Connection conn, Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {}
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {}
        }
    }

}
