package com.tracker.ProductPriceTrackingSystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sites")
public class Site {

    public Site()
    { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false)
    private String siteName;

    @Column
    private String siteUrl;

    @Column
    private String siteXpath;

    @OneToMany(mappedBy = "site")
    private Set<Price> prices;

    @OneToMany(mappedBy = "site")
    private Set<ProductAddress> productAddresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getSiteXpath() {
        return siteXpath;
    }

    public void setSiteXpath(String siteXpath) {
        this.siteXpath = siteXpath;
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
