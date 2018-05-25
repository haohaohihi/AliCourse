package cc.ipotato.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by haohao on 2018/5/25.
 */
public class InjectionAttack {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://10.108.157.158:3306/mybase";
        String username = "test";
        String password = "hello";
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();

        Scanner scanner = new Scanner(System.in);
        String un = scanner.nextLine();
        String pw = scanner.nextLine();

        String sql = "select * from user where uname='" + un + "' and upass='" + pw + "'";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("uname") + ": " + rs.getString("upass"));
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
