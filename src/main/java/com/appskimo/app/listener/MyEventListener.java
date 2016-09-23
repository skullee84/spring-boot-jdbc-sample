package com.appskimo.app.listener;

import com.appskimo.app.model.Event;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by dominic on 2016. 9. 23..
 */
@Component
public class MyEventListener {

    @EventListener
    public void handleEvent(Event event) {
        System.out.println(String.format("## evnet name: ", event.toString()));
    }

}
