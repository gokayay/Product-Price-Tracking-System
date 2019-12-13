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
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PriceRunner implements CommandLineRunner {

    PriceRunner(){}

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

    }

    @Scheduled(fixedRate = 60000)
    public void PriceAdder(){

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