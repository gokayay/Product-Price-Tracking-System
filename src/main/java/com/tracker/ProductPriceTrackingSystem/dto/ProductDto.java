package com.tracker.ProductPriceTrackingSystem.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class ProductDto implements Serializable {

    private Long id;

    private String productName;

    private String productComment;

    private String productImg;

}
