package cc.ipotato.jdbc.dbcp;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DataSourceDemo {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://10.108.157.158:3306/mybase");
        dataSource.setUsername("test");
        dataSource.setPassword("1234");
        try {
            Connection conn = dataSource.getConnection();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e + "数据库连接失败");
        }

    }
}
