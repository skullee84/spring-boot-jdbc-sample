package com.appskimo.app.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by dominic on 2016. 9. 23..
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class DataSourceConfig {

    @Bean(name = "dataSource", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Autowired
    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.appskimo.app.domain.model");
        sqlSessionFactoryBean.setDataSource(dataSource);

        return sqlSessionFactoryBean;
    }

    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.appskimo.app.domain.repository");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");

        return mapperScannerConfigurer;
    }

    @Autowired
    @Bean(name = "txManager")
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
