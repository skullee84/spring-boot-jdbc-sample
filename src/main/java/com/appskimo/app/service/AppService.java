package com.appskimo.app.service;

import java.util.List;

/**
 * Created by dominic on 2016. 9. 23..
 */
public interface AppService {

    void post(String eventName);

    List<Integer> getData();

}
