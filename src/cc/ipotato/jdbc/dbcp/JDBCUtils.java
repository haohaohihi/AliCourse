package cc.ipotato.jdbc.dbcp;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class JDBCUtils {
    private static String DBDRIVER;
    private static String DBURL;
    private static String DBUSER;
    private static String DBPASS;
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        try {
            getConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource.setDriverClassName(DBDRIVER);
        dataSource.setUrl(DBURL);
        dataSource.setUsername(DBUSER);
        dataSource.setPassword(DBPASS);

        dataSource.setInitialSize(10);
        dataSource.setMaxActive(8);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(1);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    private static void getConfig() throws IOException {
        Properties properties = new Properties();
        Reader reader = new FileReader("db.properties");
        properties.load(reader);
        DBDRIVER = properties.getProperty("driver");
        DBURL = properties.getProperty("url");
        DBUSER = properties.getProperty("user");
        DBPASS = properties.getProperty("password");
    }

}

