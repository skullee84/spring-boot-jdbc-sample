package com.appskimo.app.service.impl;

import com.appskimo.app.domain.model.Event;
import com.appskimo.app.domain.model.User;
import com.appskimo.app.domain.repository.UserRepository;
import com.appskimo.app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dominic on 2016. 9. 23..
 */
@Component
public class AppServiceImpl implements AppService {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void post(String eventName) {
        User user = new User();
        user.setName(eventName);

        userRepository.insert(user);
        publisher.publishEvent(new Event(eventName));
    }

}
