package com.tracker.ProductPriceTrackingSystem.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
public class ProductDto implements Serializable {

    private Long id;

    private String productName;

    private String productComment;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productComment, that.productComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productComment);
    }
}
