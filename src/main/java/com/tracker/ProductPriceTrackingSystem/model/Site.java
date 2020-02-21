package com.tracker.ProductPriceTrackingSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
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

    @JsonIgnore
    @OneToMany(mappedBy = "site")
    private Set<Price> prices;

    @JsonIgnore
    @OneToMany(mappedBy = "site")
    private Set<ProductAddress> productAddresses;

}
