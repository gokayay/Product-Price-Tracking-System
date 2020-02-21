package com.tracker.ProductPriceTrackingSystem.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class SiteDto implements Serializable {

    private Long id;

    private String siteName;

    private String siteUrl;

    private String siteXpath;

    private String siteImg;

}
