package cc.ipotato.jdbc;

import java.sql.*;

/**
 * Created by haohao on 2018/5/25.
 */
public class JDBCUtilsTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from sort";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
                    rs.getDouble("sprice") + " " + rs.getString("sdesc"));
        }
        JDBCUtils.close(conn, stmt, rs);
    }
}
