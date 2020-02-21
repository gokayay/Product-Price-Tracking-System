package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.dto.ProductDto;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void createProduct(ProductDto product);

    void updateProduct(Long id,ProductDto product);

    void deleteProduct(Long id);

    ProductDto oneProductDto(Long id);

    //Paginated Gets

    Page<ProductDto> getPaginatedProductsDto(Pageable pageable);

    Page<ProductDto> getPaginatedProductNameDto(String product_name,Pageable pageable);
}