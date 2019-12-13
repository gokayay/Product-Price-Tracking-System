package com.tracker.ProductPriceTrackingSystem.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.repository.ProductRepository;
import com.tracker.ProductPriceTrackingSystem.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class ScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(fixedRate = 60000)   // 1 minute
    public void reportCurrentTime() {

        log.info("The time is now {}", dateFormat.format(new Date()));
       // new PriceScheduler();
    }

}


