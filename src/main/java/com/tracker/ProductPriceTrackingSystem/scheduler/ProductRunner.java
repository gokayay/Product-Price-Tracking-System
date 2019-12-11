package com.tracker.ProductPriceTrackingSystem.scheduler;

import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.repository.ProductRepository;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class ProductRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ProductRunner.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Product pro = new Product();
        pro.setProductName("hello");
        pro.setProductComment("hello from the dark side");
        productRepository.save(pro);


        logger.info("# of cities: {}", productRepository.count());

        logger.info("All cities unsorted:");
      //  var products = (var) productRepository.findAll();
        //logger.info("{}", products);

        logger.info("------------------------");
    }
}
