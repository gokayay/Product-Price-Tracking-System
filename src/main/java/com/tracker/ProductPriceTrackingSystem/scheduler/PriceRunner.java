package com.tracker.ProductPriceTrackingSystem.scheduler;

import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.repository.ProductAddressRepository;
import com.tracker.ProductPriceTrackingSystem.repository.SiteRepository;
import com.tracker.ProductPriceTrackingSystem.repository.PriceRepository;
import com.tracker.ProductPriceTrackingSystem.repository.ProductRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class PriceRunner {

    PriceRunner(){}

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private ProductAddressRepository productAddressRepository;


    @Scheduled(fixedRate = 86400000) // 1 day
    public void PriceAdder(){

        StringMoneyConverter Smc =new StringMoneyConverter();


        /////////////////////////////
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        WebDriver driver = new ChromeDriver(chromeOptions);



        List<ProductAddress> productAddressList=productAddressRepository.findAll();

        productAddressList.forEach((productAddress) -> {

            String productPath = productAddress.getProductPath();
            System.out.println(productAddress.getProduct().getProductName() + " --> " + productAddress.getSite().getSiteName());

            driver.get(productPath);
            try {
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
            }
            catch (NoSuchElementException e){
                System.out.println("Product Address or Xpath Not Found");
            }
        });

        driver.quit();
    }
}