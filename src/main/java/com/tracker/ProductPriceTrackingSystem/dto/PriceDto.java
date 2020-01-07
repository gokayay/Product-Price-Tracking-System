package com.tracker.ProductPriceTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.model.Site;
import com.tracker.ProductPriceTrackingSystem.validation.CheckDateCustom;
import com.tracker.ProductPriceTrackingSystem.validation.DtoValidation;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class PriceDto implements Serializable {

    private Long id;

    @DtoValidation
    private Double price;

    @CheckDateCustom(pattern = "YYYY-MM-DD hh:mm:ss[.fraction]")
    private Date date;

    @JsonIgnoreProperties({"productComment","prices","productAddresses"})
    private Product product;

    @JsonIgnoreProperties({"siteUrl","siteXpath","prices","productAddresses"})
    private Site site;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceDto priceDto = (PriceDto) o;
        return Objects.equals(id, priceDto.id) &&
                Objects.equals(price, priceDto.price) &&
                Objects.equals(date, priceDto.date) &&
                Objects.equals(product, priceDto.product) &&
                Objects.equals(site, priceDto.site);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, date, product, site);
    }
}
