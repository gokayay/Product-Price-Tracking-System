package com.tracker.ProductPriceTrackingSystem.scheduler;

import com.tracker.ProductPriceTrackingSystem.crawler.StringMoneyConverter;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import com.tracker.ProductPriceTrackingSystem.model.Site;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.repository.ProductAddressRepository;
import com.tracker.ProductPriceTrackingSystem.repository.SiteRepository;
import com.tracker.ProductPriceTrackingSystem.repository.PriceRepository;
import com.tracker.ProductPriceTrackingSystem.repository.ProductRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ProductRunner.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private ProductAddressRepository productAddressRepository;

    @Override
    public void run(String... args) throws Exception {
        Crawling();
    }


    public void Crawling(){

        StringMoneyConverter Smc =new StringMoneyConverter();



        List<Site> siteList=siteRepository.findAll();

       // System.out.println(siteList.get(0));


        Site siteHb = siteRepository.findById((long) 1)
                .orElseThrow(() -> new EntityNotFoundException("Holy shit, you screwed up!"));

        String siteXpathHb = siteHb.getSiteXpath();


        Site siteTr = siteRepository.findById((long) 2)
                .orElseThrow(() -> new EntityNotFoundException("Holy shit, you screwed up!"));

        String siteXpathTr = siteTr.getSiteXpath();

        Site siteAm = siteRepository.findById((long) 3)
                .orElseThrow(() -> new EntityNotFoundException("Holy shit, you screwed up!"));

        String siteXpathAm = siteAm.getSiteXpath();

        Site siteN11 = siteRepository.findById((long) 4)
                .orElseThrow(() -> new EntityNotFoundException("Holy shit, you screwed up!"));

        String siteXpathN11 = siteN11.getSiteXpath();

        Site siteGg = siteRepository.findById((long) 1)
                .orElseThrow(() -> new EntityNotFoundException("Holy shit, you screwed up!"));

        String siteXpathGg = siteGg.getSiteXpath();


        /////////////////////////////


        List<ProductAddress> productAddressList=productAddressRepository.findAll();

        productAddressList.forEach((i) -> {
            String productPath = i.getProductPath();
            System.out.println(productPath);
        });


/*
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
*/
    }
}