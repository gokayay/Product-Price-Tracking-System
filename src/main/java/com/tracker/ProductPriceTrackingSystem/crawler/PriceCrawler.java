package com.tracker.ProductPriceTrackingSystem.crawler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.persistence.criteria.CriteriaBuilder;

public class PriceCrawler {

    public static void main(String[] args) {

        String N11Xpath="//*[@id=\"contentProDetail\"]/div/div[3]/div[2]/div[3]/div[2]/div/div/div/ins";
        String HbXpath="//*[@id=\"offering-price\"]/span[1]";
        String AmXpath="//*[@id=\"priceblock_ourprice\"]";
        String TrXpath="//*[@id=\"product-detail-app\"]/div/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div/span[2]";
        String GgXpath="//*[@id=\"sp-price-lowPrice\"]";

        //////
        String macHb ="https://www.hepsiburada.com/apple-macbook-pro-touch-bar-intel-core-i7-8750h-16gb-256gb-ssd-radeon-pro-555x-macos-15-qhd-tasinabilir-bilgisayar-mr932tu-a-gri-p-HBV00000CVXB3?magaza=N%C3%96TRON";
        String macN11 ="https://urun.n11.com/dizustu-bilgisayar/apple-macbook-pro-mv902tua-15-inc-6c-i7touch-bar26ghz256gb-s-P360031377";
        String macAm="https://www.amazon.com.tr/Apple-Macbook-Intel-%C4%B0%C5%9Flemci-Radeon/dp/B07679MWCQ/ref=sr_1_4?__mk_tr_TR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&keywords=macbook+pro&qid=1576044727&sr=8-4";
        String macTr="https://www.trendyol.com/apple/apple-macbook-pro-intel-core-i7-9750h-16gb-256gb-ssd-radeon-pro-555x-macos-15-fhd-mv902tu-a-p-6794295";
        String macGg="https://www.gittigidiyor.com/dizustu-laptop-notebook-bilgisayar/apple-macbook-pro-154-mv922tua_spp_558196?id=500097980";

        //////
        WebDriver driver = new ChromeDriver();

        //////
        driver.get(macHb);
        WebElement elementHb = driver.findElement(By.xpath(HbXpath));
        System.out.println(elementHb.getText());


        driver.get(macN11);
        WebElement elementN11 = driver.findElement(By.xpath(N11Xpath));
        System.out.println(elementN11.getText());

        driver.get(macAm);
        WebElement elementAm= driver.findElement(By.xpath(AmXpath));
        System.out.println(elementAm.getText());

        driver.get(macTr);
        WebElement elementTr= driver.findElement(By.xpath(TrXpath));
        System.out.println(elementTr.getText());

        driver.get(macGg);
        WebElement elementGg= driver.findElement(By.xpath(GgXpath));
        System.out.println(elementGg.getText());

        //////
        driver.quit();
    }

}