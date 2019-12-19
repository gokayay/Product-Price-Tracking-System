package com.tracker.ProductPriceTrackingSystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "prices")
public class Price {

    public Price()
    { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double price;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "siteId", nullable = false)
    private Site site;

    public Price(Long id, Double price, Date date, Product product, Site site) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.product = product;
        this.site = site;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(id, price1.id) &&
                Objects.equals(price, price1.price) &&
                Objects.equals(date, price1.date) &&
                Objects.equals(product, price1.product) &&
                Objects.equals(site, price1.site);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, date, product, site);
    }
}
