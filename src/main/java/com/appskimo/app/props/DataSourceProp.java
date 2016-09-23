package com.appskimo.app.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by dominic on 2016. 9. 23..
 */
@Data
@Component
@ConfigurationProperties("spring.datasource.hikari")
public class DataSourceProp {

    private String username;

}
