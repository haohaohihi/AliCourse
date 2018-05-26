package cc.ipotato.jdbc.basic;

import cc.ipotato.jdbc.beans.Sort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haohao on 2018/5/25.
 */
public class SortReader {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from sort";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Sort> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Sort(rs.getInt("sid"), rs.getString("sname"),
                    rs.getDouble("sprice"), rs.getString("sdesc")));
           }
        JDBCUtils.close(conn, stmt, rs);
        System.out.println(list);
    }
}
