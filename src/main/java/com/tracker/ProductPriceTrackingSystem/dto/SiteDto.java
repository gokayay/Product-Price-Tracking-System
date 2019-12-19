package com.tracker.ProductPriceTrackingSystem.dto;

import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;

import javax.persistence.*;
import java.util.Set;

public class SiteDto {

    private Long id;

    private String siteName;

    private String siteUrl;

    private String siteXpath;

    private Set<Price> prices;

    private Set<ProductAddress> productAddresses;



    /////////////////


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getSiteXpath() {
        return siteXpath;
    }

    public void setSiteXpath(String siteXpath) {
        this.siteXpath = siteXpath;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }

    public Set<ProductAddress> getProductAddresses() {
        return productAddresses;
    }

    public void setProductAddresses(Set<ProductAddress> productAddresses) {
        this.productAddresses = productAddresses;
    }
}
