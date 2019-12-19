package com.tracker.ProductPriceTrackingSystem.dto;


import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;

import java.util.Set;

public class ProductDto{

    private Long id;

    private String productName;

    private String productComment;

    private Set<Price> prices;

    private Set<ProductAddress> productAddresses;


    ////////////////////////


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductComment() {
        return productComment;
    }

    public void setProductComment(String productComment) {
        this.productComment = productComment;
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
