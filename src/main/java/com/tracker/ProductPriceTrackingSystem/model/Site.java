package com.tracker.ProductPriceTrackingSystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
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

    @Column
    private String siteImg;

    @OneToMany(mappedBy = "site")
    private Set<Price> prices;

    @OneToMany(mappedBy = "site")
    private Set<ProductAddress> productAddresses;

    public Site(Long id, String siteName, String siteUrl, String siteXpath, String siteImg, Set<Price> prices, Set<ProductAddress> productAddresses) {
        this.id = id;
        this.siteName = siteName;
        this.siteUrl = siteUrl;
        this.siteXpath = siteXpath;
        this.siteImg = siteImg;
        this.prices = prices;
        this.productAddresses = productAddresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Site site = (Site) o;
        return Objects.equals(id, site.id) &&
                Objects.equals(siteName, site.siteName) &&
                Objects.equals(siteUrl, site.siteUrl) &&
                Objects.equals(siteXpath, site.siteXpath) &&
                Objects.equals(siteImg, site.siteImg) &&
                Objects.equals(prices, site.prices) &&
                Objects.equals(productAddresses, site.productAddresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, siteName, siteUrl, siteXpath, siteImg, prices, productAddresses);
    }
}
