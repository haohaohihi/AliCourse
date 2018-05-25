package cc.ipotato.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Hello on 2017/11/21.
 */
public class PreparedStatementTest {
    public static String DBDRIVER = "com.mysql.jdbc.Driver";
    public static String DBURL = "jdbc:mysql://10.108.157.158:3306/mybase";
    public static String DBUSER = "test";
    public static String DBPASS = "hello";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        String update_sql = "insert into user(uname, upass) values(?,?)";
        String name = "Smith";
        String pass = "123456";
        PreparedStatement ps = conn.prepareStatement(update_sql);
        ps.setString(1, name);
        ps.setString(2, pass);
        System.out.println(ps.executeUpdate());
    }
}
