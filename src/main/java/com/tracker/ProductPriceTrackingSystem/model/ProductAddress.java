package com.tracker.ProductPriceTrackingSystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "productAddresses")
public class ProductAddress {

    public ProductAddress()
    { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false)
    private String productPath;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "siteId", nullable = false)
    private Site site;

    public ProductAddress(Long id, String productPath, Product product, Site site) {
        this.id = id;
        this.productPath = productPath;
        this.product = product;
        this.site = site;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductAddress that = (ProductAddress) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productPath, that.productPath) &&
                Objects.equals(product, that.product) &&
                Objects.equals(site, that.site);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productPath, product, site);
    }
}
