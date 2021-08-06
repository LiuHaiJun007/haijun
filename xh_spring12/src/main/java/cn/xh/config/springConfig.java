package cn.xh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({jdbcConfig.class,transactionConfig.class})//将这两个配置类整合
@PropertySource("classpath:jdbcConfig.properties")//加载
@ComponentScan("cn.xh")
@EnableTransactionManagement
//开启spring事物的注解
public class springConfig {
}
