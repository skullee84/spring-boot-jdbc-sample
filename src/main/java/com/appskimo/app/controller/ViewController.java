package com.appskimo.app.controller;

import com.appskimo.app.service.AppService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dominic on 2016. 9. 26..
 */
@Controller
public class ViewController {

    @Autowired
    private AppService appService;

    @RequestMapping("/signin")
    public void login() {}

    @RequestMapping({"/", "/home"})
    public String home(ModelMap map) {
        String randomStr = RandomStringUtils.randomAlphanumeric(10);
        map.put("data", randomStr);

        appService.post(randomStr);

        return "home";
    }

}
