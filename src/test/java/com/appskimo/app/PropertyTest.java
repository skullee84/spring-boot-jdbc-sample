package com.appskimo.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by dominic on 2016. 9. 19..
 */
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class PropertyTest {

    @Autowired
    private Environment environment;

    @Test
    public void testProps() {
        String[] temp = environment.getActiveProfiles();
        for(String s : temp) {
            display(s);
        }

        display(environment.getProperty("server.port", String.class));
        display(environment.getProperty("logging.level", String.class));
    }

    private void display(Object obj) {
        System.out.println("#################");
        System.out.println(obj.toString());
    }

}
