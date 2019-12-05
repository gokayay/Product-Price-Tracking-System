package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.model.Product;

import java.util.List;

public interface ProductService {

    void createProduct(Product product);

    void updateProduct(Long id,Product product);

    void deleteProduct(long id);

    List<Product> allProducts();

}