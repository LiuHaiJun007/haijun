package cn.xh.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class jdbcConfig {
    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.jdbcUrl}")
    private String jdbcUrl;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Bean("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource ds){
        return new JdbcTemplate(ds);
    }
    @Bean("ds")
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource cp=new ComboPooledDataSource();
        cp.setDriverClass(driverClass);
        cp.setJdbcUrl(jdbcUrl);
        cp.setUser(user);
        cp.setPassword(password);
        return cp;
    }
}
