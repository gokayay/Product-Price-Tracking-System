package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.dto.ProductAddressDto;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductAddressService {

    void createProductAddress(ProductAddressDto productAddress);

    void updateProductAddress(Long id, ProductAddressDto productAddress);

    void deleteProductAddress(Long id);

    ProductAddressDto oneProductAddressDto(Long id);

    //Paginated Gets

    Page<ProductAddressDto> getPaginatedProductAddressesDto(Pageable pageable);

    Page<ProductAddressDto> getPaginatedProductPathDto(String product_path, Pageable pageable);
}