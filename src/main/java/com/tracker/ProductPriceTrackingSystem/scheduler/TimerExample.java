package com.tracker.ProductPriceTrackingSystem.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimerExample {

    private static final Logger log = LoggerFactory.getLogger(TimerExample.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(fixedRate = 300000)   // 5 minutes
    public void reportCurrentTime() {

        log.info("The time is now {}", dateFormat.format(new Date()));

    }

}

