package com.tracker.ProductPriceTrackingSystem.crawler;

public class StringMoneyConverter {

    StringMoneyConverter(){
        // bu class düzensiz bir şekilde crawl edilen price değerleri için düzeltip double'a çevirme işlemi yapar.
    }


    public double Converter1(String str){

        String str2= str.replace(" TL", "");
        String str3 = str2.replace(".","");
        String str4 = str3.replace(",",".");
        double parsedStr = Double.parseDouble(str4);

        return parsedStr;
    }



    public double Converter2(String str){

        String str2= str.replace("₺", "");
        String str3 = str2.replace(".","");
        String str4 = str3.replace(",",".");
        double parsedStr = Double.parseDouble(str4);

        return parsedStr;
    }

}
