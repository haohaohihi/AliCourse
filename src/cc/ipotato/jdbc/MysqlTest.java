package cc.ipotato.jdbc;

import java.sql.*;

/**
 * Created by Hello on 2017/11/17.
 */
public class MysqlTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // step1: 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // step2: 配置连接信息(url, 用户名, 密码)
        String url = "jdbc:mysql://10.108.157.158:3306/mybase";
        String username = "test";
        String password = "hello";
        // step3: 获取连接
        Connection conn = DriverManager.getConnection(url, "test", "hello");
        // step4: 获取statement, 语句执行平台
        Statement stmt = conn.createStatement();
        // step5: 编写SQL语句
        String sql = "select * from sort";
        String usql = "update sort set sprice=sprice+50 where sid=6";
        // step6: 执行查询, 获得查询结果
        ResultSet rs = stmt.executeQuery(sql);
//        int udr = stmt.executeUpdate(usql);
        // step7: 处理查询结果
        while(rs.next()){
            System.out.print(rs.getInt(1) + " " + rs.getString(2) + " " +
                             rs.getDouble("sprice") + " " + rs.getString("sdesc"));
            System.out.println();
        }
//        System.out.println("--------");
//        System.out.println(udr);
        // step8: 关闭资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
