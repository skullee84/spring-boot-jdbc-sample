package com.appskimo.app.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by dominic on 2016. 9. 23..
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

//    @Autowired
//    private DataSourceProp dataSourceProp;

    private HikariConfig getHikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mariadb://localhost:3306/develop");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("");
        hikariConfig.setPoolName("hikariCP");
        hikariConfig.setMaximumPoolSize(5);

        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return hikariConfig;
    }

    @Bean(name = "hikariDataSource", destroyMethod = "close")
//    @ConfigurationProperties("spring.datasource.hikari")
    public HikariDataSource hikariDataSource() {
//        dataSourceProp.getUsername();
//        DataSourceBuilder.create().type(HikariDataSource.class).build();
        return new HikariDataSource(getHikariConfig());
    }

    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean(HikariDataSource hikariDataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.appskimo.app.model");
        sqlSessionFactoryBean.setDataSource(hikariDataSource);

        return sqlSessionFactoryBean;
    }

    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.appskimo.app.repository");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");

        return mapperScannerConfigurer;
    }

    @Bean(name = "txManager")
    public DataSourceTransactionManager dataSourceTransactionManager(HikariDataSource hikariDataSource) {
        return new DataSourceTransactionManager(hikariDataSource);
    }

}
