package com.tracker.ProductPriceTrackingSystem.dto;

import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.model.Site;
import com.tracker.ProductPriceTrackingSystem.validation.CheckDateCustom;
import com.tracker.ProductPriceTrackingSystem.validation.DtoValidation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class PriceDto implements Serializable {

    private Long id;

    @DtoValidation
    private Double price;

    @CheckDateCustom(pattern = "YYYY-MM-DD hh:mm:ss[.fraction]")
    private Date date;

    private Product product;

    private Site site;

}
