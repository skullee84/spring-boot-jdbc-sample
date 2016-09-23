package com.appskimo.app.service.impl;

import com.appskimo.app.model.Event;
import com.appskimo.app.props.DataSourceProp;
import com.appskimo.app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Created by dominic on 2016. 9. 23..
 */
@Component
public class AppServiceImpl implements AppService {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private DataSourceProp dataSourceProp;

    @Override
    public void post(String eventName) {
        System.out.println(dataSourceProp.getUsername());
        publisher.publishEvent(new Event(eventName));
    }

}
