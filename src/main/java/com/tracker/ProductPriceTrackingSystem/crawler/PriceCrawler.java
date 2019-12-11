package com.tracker.ProductPriceTrackingSystem.crawler;

import java.util.List;

import com.tracker.ProductPriceTrackingSystem.controller.ProductController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;


public class PriceCrawler {

    public static void main(String[] args) {

        StringMoneyConverter Smc =new StringMoneyConverter();

        String N11Xpath="//*[@id=\"contentProDetail\"]/div/div[3]/div[2]/div[3]/div[2]/div/div/div/ins";
        String AmXpath="//*[@id=\"priceblock_ourprice\"]";
        String TrXpath="//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div/span[2]";
        String GgXpath="//*[@id=\"sp-price-lowPrice\"]";
        String HbXpath="//*[@id=\"offering-price\"]";

        //////
        String macHb ="https://www.hepsiburada.com/apple-macbook-pro-touch-bar-intel-core-i7-8750h-16gb-256gb-ssd-radeon-pro-555x-macos-15-qhd-tasinabilir-bilgisayar-mr932tu-a-gri-p-HBV00000CVXB3?magaza=N%C3%96TRON";
        String macN11="https://urun.n11.com/dizustu-bilgisayar/apple-macbook-pro-mv902tua-15-inc-6c-i7touch-bar26ghz256gb-s-P360031377";
        String macAm="https://www.amazon.com.tr/Apple-Macbook-Intel-%C4%B0%C5%9Flemci-Radeon/dp/B07679MWCQ/ref=sr_1_4?__mk_tr_TR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&keywords=macbook+pro&qid=1576044727&sr=8-4";
        String macTr="https://www.trendyol.com/apple/apple-macbook-pro-intel-core-i7-9750h-16gb-256gb-ssd-radeon-pro-555x-macos-15-fhd-mv902tu-a-p-6794295";
        String macGg="https://www.gittigidiyor.com/dizustu-laptop-notebook-bilgisayar/apple-macbook-pro-154-mv922tua_spp_558196?id=500097980";
        String tvHb="https://www.hepsiburada.com/rani-d1-tv-duvar-unitesi-modern-ahsap-ayakli-tv-sehpasi-ceviz-beyaz-p-HBV00000DFYTY";

        //////
        WebDriver driver = new ChromeDriver();

        /////
        //Hepsiburada

        driver.get(macHb);
        WebElement elementHb = driver.findElement(By.xpath(HbXpath));
        String elementHb_s = elementHb.getText();

        double elementHb_d = Smc.Converter1(elementHb_s);
        System.out.println(elementHb_d);

        //N11

        driver.get(macN11);
        WebElement elementN11 = driver.findElement(By.xpath(N11Xpath));
        String elementN11_s = elementN11.getText();

        double elementN11_d = Smc.Converter1(elementN11_s);
        System.out.println(elementN11_d);

        //Amazon

        driver.get(macAm);
        WebElement elementAm= driver.findElement(By.xpath(AmXpath));
        String elementAm_s = elementAm.getText();

        double elementAm_d = Smc.Converter2(elementAm_s);
        System.out.println(elementAm_d);

        //Trendyol

        driver.get(macTr);
        WebElement elementTr= driver.findElement(By.xpath(TrXpath));
        String elementTr_s = elementTr.getText();

        double elementTr_d = Smc.Converter1(elementTr_s);
        System.out.println(elementTr_d);

        //Gittigidiyor

        driver.get(macGg);
        WebElement elementGg= driver.findElement(By.xpath(GgXpath));
        String elementGg_s = elementGg.getText();

        double elementGg_d = Smc.Converter1(elementGg_s);
        System.out.println(elementGg_d);
        //////
        driver.quit();
    }

}