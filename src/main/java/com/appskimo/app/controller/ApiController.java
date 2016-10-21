package com.appskimo.app.controller;

import com.appskimo.app.common.exception.OrderValidationException;
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
public class ApiController {

    @Autowired private AppService appService;

    @RequestMapping("/data")
    public Object data() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", appService.getData());

        return map;
    }

    @RequestMapping("/exception/default")
    public Object defaultException() {
        throw new RuntimeException("something wrong");
    }

    @RequestMapping("/exception/order")
    public Object orderException() {
        throw new OrderValidationException("확인해주세요");
    }

}
