package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.dto.ProductAddressDto;
import com.tracker.ProductPriceTrackingSystem.dto.ProductDto;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    Page<ProductDto> convertToDtoPage(Page<Product> product);

    Page<ProductDto> getPaginatedProductsDto(Pageable pageable);

    Page<ProductDto> getPaginatedProductNameDto(String product_name,Pageable pageable);
}