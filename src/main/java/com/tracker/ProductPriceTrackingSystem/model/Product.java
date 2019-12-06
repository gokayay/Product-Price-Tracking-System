package com.tracker.ProductPriceTrackingSystem.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
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

    @OneToMany(mappedBy = "price", cascade = CascadeType.ALL)
    private Set<Product> products;
}
