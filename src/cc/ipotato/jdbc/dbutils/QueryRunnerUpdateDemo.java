package cc.ipotato.jdbc.dbutils;

import cc.ipotato.jdbc.basic.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by haohao on 2018/5/26.
 */
public class QueryRunnerUpdateDemo {
    private static Connection conn = JDBCUtils.getConnection();
    public static void main(String[] args) throws SQLException {
//        insert();
//        update();
        delete();
    }

    public static void delete() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "DELETE FROM sort WHERE sid=?";
        int row = qr.update(conn, sql, 7);
        System.out.println(row);
        DbUtils.closeQuietly(conn);
    }

    public static void update() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "UPDATE sort set sprice=? where sid=?";
        Object[] params = {3000, 1};
        int row = qr.update(conn, sql, params);
        System.out.println(row);
        DbUtils.closeQuietly(conn);
    }

    public static void insert() throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "INSERT INTO sort (sname, sprice, sdesc) VALUES (?, ?, ?)";
        Object[] params = {"体育用品", 222.21, "购买体育用品"};
        int row = qr.update(conn, sql, params);
        System.out.println(row);
        DbUtils.closeQuietly(conn);
    }
}
