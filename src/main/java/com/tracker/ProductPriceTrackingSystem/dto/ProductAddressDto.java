package com.tracker.ProductPriceTrackingSystem.dto;

import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.model.Site;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
public class ProductAddressDto implements Serializable {

    private Long id;

    private String productPath;

    private Product product;

    private Site site;

}
