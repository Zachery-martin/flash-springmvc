package edu.nf.flash.service.config;/**
 * @ClassName: AppConfig
 * @Author: Zachery
 * @Data: 15:42
 **/

import edu.nf.flash.dao.config.DaoConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @ClassName: AppConfig
 * @Author: Zachery
 * @Data: 15:42
 **/
@Configuration
@ComponentScan("edu.nf.flash.service")
@Import(DaoConfig.class)
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
