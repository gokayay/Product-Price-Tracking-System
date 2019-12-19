package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.dto.ProductAddressDto;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;

import java.util.List;
import java.util.Optional;

public interface ProductAddressService {

    void createProductAddress(ProductAddress productAddress);

    void updateProductAddress(Long id, ProductAddress productAddress);

    void deleteProductAddress(Long id);

    List<ProductAddress> allProductAddresses();

    Optional<ProductAddress> oneProductAddress(Long id);

    List<ProductAddressDto> allProductAddressesDto();

    ProductAddressDto oneProductAddressDto(Long id);
}