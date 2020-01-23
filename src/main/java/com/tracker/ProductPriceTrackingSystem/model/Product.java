package com.tracker.ProductPriceTrackingSystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
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

    @Column
    private String productImg;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<Price> prices;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<ProductAddress> productAddresses;

    public Product(Long id, String productName, String productComment, String productImg, Set<Price> prices, Set<ProductAddress> productAddresses) {
        this.id = id;
        this.productName = productName;
        this.productComment = productComment;
        this.productImg = productImg;
        this.prices = prices;
        this.productAddresses = productAddresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productComment, product.productComment) &&
                Objects.equals(productImg, product.productImg) &&
                Objects.equals(prices, product.prices) &&
                Objects.equals(productAddresses, product.productAddresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productComment, productImg, prices, productAddresses);
    }
}
