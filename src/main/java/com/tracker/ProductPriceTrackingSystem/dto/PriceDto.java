package com.tracker.ProductPriceTrackingSystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.model.Site;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class PriceDto implements Serializable {

    private Long id;

    private Double price;

    private Date date;

    @JsonIgnore
    private Product product;

    @JsonIgnore
    private Site site;

    public PriceDto(Long id, Double price, Date date, Product product, Site site) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.product = product;
        this.site = site;
    }

    public PriceDto() {
    }

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
