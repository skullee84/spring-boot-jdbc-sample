package com.appskimo.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by dominic on 2016. 9. 23..
 */
@RestController
public class ApiController {

    @RequestMapping("/data")
    public Object data() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", IntStream.range(0, 10).boxed().collect(Collectors.toList()));

        return map;
    }

}
