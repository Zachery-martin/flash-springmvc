package edu.nf.flash.dao.config;/**
 * @ClassName: DaoConfig
 * @Author: Zachery
 * @Data: 20:33
 **/

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName: DaoConfig
 * @Author: Zachery
 * @Data: 20:33
 **/
@Configuration
@MapperScan("edu.nf.flash.dao")
public class DaoConfig {

    /**
     * 连接池
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/flash?useSSL=true&useUnicode=true&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setMaxActive(200);
        ds.setInitialSize(5);
        ds.setMinIdle(5);
        ds.setMaxWait(60000);
        ds.setMinEvictableIdleTimeMillis(300000);
        ds.setTimeBetweenEvictionRunsMillis(60000);
        ds.setTestWhileIdle(true);
        ds.setTestOnReturn(false);
        ds.setPoolPreparedStatements(false);
        ds.setValidationQuery("select 1");
        return ds;
    }

    /**
     * 配置SqlSessionFactoryBean
     * @return
     * @throws IOException
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //注入数据源
        factoryBean.setDataSource(dataSource());
        //设置实体包的别名
        factoryBean.setTypeAliasesPackage("edu.nf.flash.entity");
        //指定mapper映射文件的路径
        PathMatchingResourcePatternResolver resource = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resource.getResources("classpath:mapper/*.xml"));
        //配置分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties props = new Properties();
        props.setProperty("helperDialect", "mysql");
        props.setProperty("supportMethodsArguments", "true");
        props.setProperty("rowBoundsWithCount", "true");
        pageInterceptor.setProperties(props);
        factoryBean.setPlugins(pageInterceptor);
        return factoryBean;
    }
}
