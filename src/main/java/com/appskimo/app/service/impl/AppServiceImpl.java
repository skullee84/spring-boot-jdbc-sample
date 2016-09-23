package com.appskimo.app.service.impl;

import com.appskimo.app.model.Event;
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

    @Override
    public void post(String eventName) {
        publisher.publishEvent(new Event(eventName));
    }

}
