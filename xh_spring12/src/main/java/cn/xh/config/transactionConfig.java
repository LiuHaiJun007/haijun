package cn.xh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class transactionConfig {


    @Bean("transactionManager")
    public DataSourceTransactionManager creatTransactionManager(DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}
