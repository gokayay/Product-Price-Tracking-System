package com.tracker.ProductPriceTrackingSystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
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

    @OneToMany(mappedBy = "price", cascade = CascadeType.ALL)
    private Set<ECommerceSite> eCommerceSites;

}
