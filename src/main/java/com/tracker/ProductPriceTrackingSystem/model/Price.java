package com.tracker.ProductPriceTrackingSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.ScrollableResults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "siteId", nullable = false)
    private ECommerceSite eCommerceSite;

    @Column
    private String price;

    @Column
    private String date;

    @Column
    private String url;






///////////////////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ECommerceSite geteCommerceSite() {
        return eCommerceSite;
    }

    public void seteCommerceSite(ECommerceSite eCommerceSite) {
        this.eCommerceSite = eCommerceSite;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
