package com.tracker.ProductPriceTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.model.Site;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class ProductAddressDto implements Serializable {

    private Long id;

    private String productPath;

    @JsonIgnoreProperties({"productComment","prices","productAddresses"})
    private Product product;

    @JsonIgnoreProperties({"siteUrl","siteXpath","prices","productAddresses"})
    private Site site;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductAddressDto that = (ProductAddressDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productPath, that.productPath) &&
                Objects.equals(product, that.product) &&
                Objects.equals(site, that.site);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productPath, product, site);
    }
}
