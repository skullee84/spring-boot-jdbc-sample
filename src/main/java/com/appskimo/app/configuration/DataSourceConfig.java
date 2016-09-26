package com.appskimo.app.configuration;

import com.appskimo.app.properties.DataSourceProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Map;

/**
 * Created by dominic on 2016. 9. 23..
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class DataSourceConfig {

    @Bean(name = "dataSourceProperties")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Autowired
    @Bean(name = "hikariDataSource", destroyMethod = "close")
    public HikariDataSource hikariDataSource(DataSourceProperties dataSourceProperties) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(dataSourceProperties.getDriverClassName());
        hikariConfig.setJdbcUrl(dataSourceProperties.getJdbcUrl());
        hikariConfig.setUsername(dataSourceProperties.getUsername());
        hikariConfig.setPassword(dataSourceProperties.getPassword());
        hikariConfig.setPoolName(dataSourceProperties.getPoolName());
        hikariConfig.setMaximumPoolSize(dataSourceProperties.getMaximumPoolSize());

        Map<String, String> sourceProperties = dataSourceProperties.getDataSourceProperties();
        hikariConfig.addDataSourceProperty("cachePrepStmts", sourceProperties.get("cachePrepStmts"));
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", sourceProperties.get("prepStmtCacheSize"));
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", sourceProperties.get("prepStmtCacheSqlLimit"));

        return new HikariDataSource(hikariConfig);
    }

    // The same as the above.
//    @Bean(name = "dataSource", destroyMethod = "close")
//    @ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().type(HikariDataSource.class).build();
//    }

    @Autowired
    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(HikariDataSource hikariDataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.appskimo.app.domain.model");
        sqlSessionFactoryBean.setDataSource(hikariDataSource);

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
    public DataSourceTransactionManager dataSourceTransactionManager(HikariDataSource hikariDataSource) {
        return new DataSourceTransactionManager(hikariDataSource);
    }

}
