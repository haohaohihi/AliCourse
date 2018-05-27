package cc.ipotato.jdbc.dbcp;

import cc.ipotato.jdbc.beans.Sort;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DataSourceQueryTest {
    private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    public static void main(String[] args) throws SQLException {
//        arrayHandler();
//        arrayListHandler();
//        beanHandler();
//        beanListHandler();
//        columnListHandler();
//        scalarHandler();
//        mapHandler();
        mapListHandler();
    }

    public static void arrayHandler() throws SQLException {
        String sql = "SELECT * FROM sort";
        Object[] result = qr.query(sql, new ArrayHandler());
        for (Object obj: result) {
            System.out.print(obj + "  ");
        }
    }

    /*
    2. ArrayListHandler, 将每一条结果存储到Object数组中，并将数组存储到List中
     */
    public static void arrayListHandler() throws SQLException {
        String sql = "SELECT * FROM sort where sid > ?";
        List<Object[]> result= qr.query(sql, new ArrayListHandler(), 3);
        for (Object[] objs: result) {
            for (Object obj: objs) {
                System.out.print(obj + "  ");
            }
            System.out.println();
        }
    }

    /*
    3. BeanHandler, 将查询结果的第一条封装成JavaBean对象
       若查询结果为空，则result为null
     */
    public static void beanHandler() throws SQLException {
        String sql = "SELECT * FROM sort where sid > ?";
        Sort result = qr.query(sql, new BeanHandler<>(Sort.class), 3);
        System.out.println(result);
    }

    /*
    4. BeanListHandler, 将查询结果的每一条封装成JavaBean对象，并将所有JavaBean对象存储到List中
     */
    public static void beanListHandler() throws SQLException {
        String sql = "SELECT * FROM sort where sid > ?";
        List<Sort> result = qr.query(sql, new BeanListHandler<>(Sort.class), 2);
        for (Sort s: result) {
            System.out.println(s);
        }
    }

    /*
    5. ConlumnListHandler, 将查询结果的指定列存入List中
     */
    public static void columnListHandler() throws SQLException {
        String sql = "SELECT * FROM sort";
        List<Object> result = qr.query(sql, new ColumnListHandler<>("sname"));
        System.out.println(result);
    }

    /*
    6. ScalarHandler, 对于查询后只有一个结果, 比如聚合查询count
     */
    public static void scalarHandler() throws SQLException {
        String sql = "SELECT COUNT(*) FROM sort";
        long count = qr.query(sql, new ScalarHandler<>());
        System.out.println(count);
    }

    /*
    7. MapHandler, 将查询结果的第一行数据，封装到一个Map对象中
     */
    public static void mapHandler() throws SQLException {
        String sql = "SELECT * FROM sort";
        Map<String, Object> resultMap = qr.query(sql, new MapHandler());
        for (Map.Entry<String, Object> entry: resultMap.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }

    /*
    8. MapListHandler, 将每一个查询结果封装成Map对象，并将所有Map对象存储到一个List中
     */
    public static void mapListHandler() throws SQLException {
        String sql = "SELECT * FROM sort";
        List<Map<String, Object>> result = qr.query(sql, new MapListHandler());
        for (Map<String, Object> map: result) {
            for (Map.Entry<String, Object> entry: map.entrySet()) {
                System.out.print(entry.getKey() + "..." + entry.getValue() + "  ");
            }
            System.out.println();
        }
    }
}
