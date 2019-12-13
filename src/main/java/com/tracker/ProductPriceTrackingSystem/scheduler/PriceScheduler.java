package com.tracker.ProductPriceTrackingSystem.scheduler;

import com.tracker.ProductPriceTrackingSystem.crawler.StringMoneyConverter;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import com.tracker.ProductPriceTrackingSystem.repository.PriceRepository;
import com.tracker.ProductPriceTrackingSystem.repository.ProductAddressRepository;
import com.tracker.ProductPriceTrackingSystem.repository.ProductRepository;
import com.tracker.ProductPriceTrackingSystem.repository.SiteRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;

public class PriceScheduler {

    private static final Logger logger = LoggerFactory.getLogger(ProductRunner.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private ProductAddressRepository productAddressRepository;



    @Scheduled(fixedRate = 60000)
    public void Crawling(){

        StringMoneyConverter Smc =new StringMoneyConverter();


        /////////////////////////////
        WebDriver driver = new ChromeDriver();


        List<ProductAddress> productAddressList=productAddressRepository.findAll();

        productAddressList.forEach((productAddress) -> {

            String productPath = productAddress.getProductPath();

            driver.get(productPath);
            WebElement element = driver.findElement(By.xpath(productAddress.getSite().getSiteXpath()));
            String elementString = element.getText();

            double elementDouble = Smc.Converter1(elementString);

            System.out.println(elementDouble);

            Price price = new Price();
            Date date = new Date();

            price.setSite(productAddress.getSite());
            price.setProduct(productAddress.getProduct());
            price.setPrice(elementDouble);
            price.setDate(date);

            priceRepository.save(price);

        });

        driver.quit();
    }

}
