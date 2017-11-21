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
    public static String DBURL = "jdbc:mysql://10.108.157.14:3306/test";
    public static String DBUSER = "test";
    public static String DBPASS = "hello_1234";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        String update_sql = "insert into stu(id, name) values(?,?)";
        int id = 3;
        String name = "Mr' Smith";
        PreparedStatement ps = conn.prepareStatement(update_sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        System.out.println(ps.executeUpdate());
    }
}
