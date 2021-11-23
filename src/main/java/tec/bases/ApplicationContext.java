package tec.bases;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariConfig;


public class ApplicationContext {

    public ApplicationContext() {
        var hikariDataSource = initHikariDataSource();
    }

    private static HikariDataSource initHikariDataSource() {

        HikariConfig config = new HikariConfig("/database.properties");
        return new HikariDataSource(config);
    }
    
}
