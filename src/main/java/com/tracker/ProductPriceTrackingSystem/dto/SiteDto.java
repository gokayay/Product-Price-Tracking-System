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
public class SiteDto implements Serializable {

    private Long id;

    private String siteName;

    //isValidURl
    private String siteUrl;

    private String siteXpath;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteDto siteDto = (SiteDto) o;
        return Objects.equals(id, siteDto.id) &&
                Objects.equals(siteName, siteDto.siteName) &&
                Objects.equals(siteUrl, siteDto.siteUrl) &&
                Objects.equals(siteXpath, siteDto.siteXpath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, siteName, siteUrl, siteXpath);
    }
}
