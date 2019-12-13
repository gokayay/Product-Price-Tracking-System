package com.tracker.ProductPriceTrackingSystem.scheduler;

import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class StringMoneyConverter {

    public StringMoneyConverter(){
        // bu class düzensiz bir şekilde crawl edilen price değerleri için düzeltip double'a çevirme işlemi yapar.
    }


    public double Converter1(String str){
        String str1= str.replace("₺", "");
        String str2= str1.replace(" TL", "");
        String str3 = str2.replace(".","");
        String str4 = str3.replace(",",".");
        double parsedStr = Double.parseDouble(str4);

        return parsedStr;
    }

}
