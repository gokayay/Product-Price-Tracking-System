package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.dto.ProductAddressDto;
import com.tracker.ProductPriceTrackingSystem.dto.ProductDto;
import com.tracker.ProductPriceTrackingSystem.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void createProduct(Product product);

    void updateProduct(Long id,Product product);

    void deleteProduct(Long id);

    List<Product> allProducts();

    Optional<Product> oneProduct(Long id);

    List<ProductDto> allProductsDto();

    ProductDto oneProductDto(Long id);
}