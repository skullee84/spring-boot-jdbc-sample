package com.appskimo.app.listener;

import com.appskimo.app.domain.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by dominic on 2016. 9. 23..
 */
@Component
public class MyEventListener {
    private static final Logger logger = LoggerFactory.getLogger(MyEventListener.class);

    @EventListener
    public void handleEvent(Event event) {
        logger.debug("## event name: {}", event);
    }

}
