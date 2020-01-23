package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.dto.ProductAddressDto;
import com.tracker.ProductPriceTrackingSystem.dto.SiteDto;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import com.tracker.ProductPriceTrackingSystem.model.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    Page<ProductAddressDto> convertToDtoPage(Page<ProductAddress> productAddress);

    Page<ProductAddressDto> getPaginatedProductAddressesDto(Pageable pageable);
}