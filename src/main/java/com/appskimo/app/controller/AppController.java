package com.appskimo.app.controller;

import com.appskimo.app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dominic on 2016. 9. 23..
 */
@RestController
public class AppController {

    @Autowired private AppService appService;

    @RequestMapping({ "/", "home" })
    public Object sample(String eventName) {
        Map<String, String> map = new HashMap<>();
        map.put("data", eventName);

        appService.post(eventName);

        return map;
    }

}
