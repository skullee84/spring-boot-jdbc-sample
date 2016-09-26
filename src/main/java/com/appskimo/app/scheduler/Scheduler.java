package com.appskimo.app.scheduler;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by dominic on 2016. 9. 26..
 */
@Component
public class Scheduler {

    private static final FastDateFormat fastDateFormat = FastDateFormat.getInstance("YYYY/MM/DD HH:mm:ss");
    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);

    @Scheduled(fixedRate = 5000)
    public void helloWorldTask() {
        logger.info("Fxied rate {}", fastDateFormat.format(new Date()));
    }

    @Scheduled(cron = "0/10 * * * * *")
    public void runEvery10Sec() {
        logger.info("Cron expression {}", fastDateFormat.format(new Date()));
    }

}
