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
@Table(name = "products")
public class Product {

    public Product()
    { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false)
    private String productName;

    @Column
    private String productComment;

    @Column
    private String productImg;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<Price> prices;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<ProductAddress> productAddresses;

}
