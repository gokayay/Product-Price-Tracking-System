package com.tracker.ProductPriceTrackingSystem.scheduler;

import com.tracker.ProductPriceTrackingSystem.crawler.StringMoneyConverter;
import com.tracker.ProductPriceTrackingSystem.model.ECommerceSite;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.repository.ECommerceSiteRepository;
import com.tracker.ProductPriceTrackingSystem.repository.PriceRepository;
import com.tracker.ProductPriceTrackingSystem.repository.ProductRepository;
import lombok.ToString;
import lombok.var;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ProductRunner.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private ECommerceSiteRepository eCommerceSiteRepository;

    @Override
    public void run(String... args) throws Exception {
        Crawling();
    }


    public void Crawling(){

        StringMoneyConverter Smc =new StringMoneyConverter();

        ArrayList<String> myXpathList = new ArrayList<>();
        ArrayList<String> myHbPriceList = new ArrayList<>();
        ArrayList<String> myN11PriceList = new ArrayList<>();
        ArrayList<String> myTrPriceList = new ArrayList<>();
        ArrayList<String> myGgPriceList = new ArrayList<>();
        ArrayList<String> myAmPriceList = new ArrayList<>();


        for(int i=1;i<=5;i++){

            ECommerceSite eCommerceSite = eCommerceSiteRepository.findById((long) i)
                    .orElseThrow(() -> new EntityNotFoundException("Holy shit, you screwed up!"));


            myXpathList.add(eCommerceSite.getSiteXpath());

            logger.info("------------------------");
            logger.info("------------------------");
        }
        System.out.println(myXpathList.get(0));
        System.out.println(myXpathList.get(1));
        System.out.println(myXpathList.get(2));
        System.out.println(myXpathList.get(3));
        System.out.println(myXpathList.get(4));


       List<Price> prices=priceRepository.findAll();

       prices.forEach(price -> {
      price.setPrice("bjb");
priceRepository.save(price);
       });


        for(int i=6;i<=10;i++) {  ///////////////////////////////Burası dinamik olmalı////////////////////////////////
            Price priceUrl= priceRepository.findById((long)i)
                    .orElseThrow(() -> new EntityNotFoundException("Holy shit, you screwed up!"));

            logger.info("------------------------");
            logger.info("------------------------");

            Long eCommerceId =priceUrl.geteCommerceSite().getId();
            if(eCommerceId == 1)
                myHbPriceList.add(priceUrl.getUrl());
            else if(eCommerceId == 2)
                myN11PriceList.add(priceUrl.getUrl());
            else if(eCommerceId == 3)
                myTrPriceList.add(priceUrl.getUrl());
            else if(eCommerceId == 4)
                myGgPriceList.add(priceUrl.getUrl());
            else if(eCommerceId == 5)
                myAmPriceList.add(priceUrl.getUrl());
        }

        WebDriver driver = new ChromeDriver();

        //if website is hepsiburada.com

        String strUrlHb = myHbPriceList.get(0); // it should be dynamic

        driver.get(strUrlHb);
        WebElement elementHb = driver.findElement(By.xpath(myXpathList.get(0)));
        String elementHb_s = elementHb.getText();

        double elementHb_d = Smc.Converter1(elementHb_s);

        logger.info("----------W O W  I T ' S  W O R K I N G !--------------");
        System.out.println(elementHb_d);
        String elementHb_ds= Double.toString(elementHb_d);

        //if website is N11.com

        String strUrlN11 = myN11PriceList.get(0);  // it should be dynamic

        driver.get(strUrlN11);
        WebElement elementN11 = driver.findElement(By.xpath(myXpathList.get(1)));
        String elementN11_s = elementN11.getText();

        double elementN11_d = Smc.Converter1(elementN11_s);

        logger.info("----------W O W  I T ' S  W O R K I N G !--------------");
        System.out.println(elementN11_d);
        String elementN11_ds= Double.toString(elementN11_d);

        //if website is Trendyol.com

        String strUrlTr = myTrPriceList.get(0);  // it should be dynamic

        driver.get(strUrlTr);
        WebElement elementTr = driver.findElement(By.xpath(myXpathList.get(2)));
        String elementTr_s = elementTr.getText();

        double elementTr_d = Smc.Converter1(elementTr_s);
        String elementTr_ds= Double.toString(elementTr_d);

        logger.info("----------W O W  I T ' S  W O R K I N G !--------------");
        System.out.println(elementTr_d);

        //if website is Gittigidiyor.com

        String strUrlGg = myGgPriceList.get(0);  // it should be dynamic

        driver.get(strUrlGg);
        WebElement elementGg = driver.findElement(By.xpath(myXpathList.get(3)));
        String elementGg_s = elementGg.getText();

        double elementGg_d = Smc.Converter1(elementGg_s);

        logger.info("----------W O W  I T ' S  W O R K I N G !--------------");
        System.out.println(elementGg_d);

        //if website is Amazon.com.tr

        String strUrlAm = myAmPriceList.get(0);  // it should be dynamic

        driver.get(strUrlAm);
        WebElement elementAm = driver.findElement(By.xpath(myXpathList.get(4)));
        String elementAm_s = elementAm.getText();

        double elementAm_d = Smc.Converter2(elementAm_s);

        logger.info("----------W O W  I T ' S  W O R K I N G !--------------");
        System.out.println(elementAm_d);

        driver.quit();


        for (int i=6;i<=10;i++){
            Price price = priceRepository.findById((long) i)
                    .orElseThrow(() -> new EntityNotFoundException("Holy shit, you screwed up!"));
            if(i == 6) {
                price.setPrice(elementHb_ds);
            }
            else if(i == 7){
                price.setPrice(elementN11_ds);
            }
            else if(i == 8){
                price.setPrice(elementTr_ds);
            }
             // 9 and 10
        }



    }








}
