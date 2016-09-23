package com.appskimo.app.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by JKLEE on 2016-09-23.
 */
@Data
//@ToString
@Component
@ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
public class DataSourceProperties {
    public static final String PREFIX = "spring.datasource.hikari";

    private String driverClassName;
    private String jdbcUrl;
    private String username;
    private String password;
    private String poolName;
    private Integer maximumPoolSize;
    private Map<String, String> dataSourceProperties;

}
