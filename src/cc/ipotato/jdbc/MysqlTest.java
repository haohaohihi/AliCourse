package cc.ipotato.jdbc;

import java.sql.*;

/**
 * Created by Hello on 2017/11/17.
 */
public class MysqlTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");
        } catch (ClassNotFoundException e) {
            System.out.println("加载MySQL驱动失败！");
            e.printStackTrace();
        }

        String url = "jdbc:mysql://10.108.157.14:3306/test_db";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, "haohao", "hello_1234");
            Statement stmt = conn.createStatement();
            System.out.println("成功连接到数据库！");
            String sql = "select * from stu";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.print(rs.getString(1) + " " + rs.getInt(2));
                System.out.println();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}