package com.tracker.ProductPriceTrackingSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "ecommercesites")
public class ECommerceSite {

    public ECommerceSite() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false)
    private String siteName;

    @Column
    private String siteXpath;

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

    public String getSiteXpath() {
        return siteXpath;
    }

    public void setSiteXpath(String siteXpath) {
        this.siteXpath = siteXpath;
    }
}
