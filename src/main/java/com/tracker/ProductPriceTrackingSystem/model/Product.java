package com.tracker.ProductPriceTrackingSystem.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
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

    @OneToMany(mappedBy = "product")
    private Set<Price> prices;

    @OneToMany(mappedBy = "product")
    private Set<ProductAddress> productAddresses;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductComment() {
        return productComment;
    }

    public void setProductComment(String productComment) {
        this.productComment = productComment;
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
