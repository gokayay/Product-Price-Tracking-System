package com.tracker.ProductPriceTrackingSystem.service.impl;


import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import com.tracker.ProductPriceTrackingSystem.repository.ProductAddressRepository;
import com.tracker.ProductPriceTrackingSystem.service.ProductAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductAddressServiceImpl implements ProductAddressService {

    @Autowired
    ProductAddressRepository productAddressRepository;

    @Override
    public void createProductAddress(ProductAddress productAddress) {

        productAddressRepository.save(productAddress);
    }


    @Override
    public void updateProductAddress(Long id, ProductAddress productAddress) {
        Optional<ProductAddress> existedProductAddress = productAddressRepository.findById(id);

        if (!existedProductAddress.isPresent())
            throw new UnsupportedOperationException("Product address not found");

        ProductAddress exProductAddress = existedProductAddress.get();
        productAddressRepository.save(exProductAddress);
    }


    @Override
    public void deleteProductAddress(Long id) {

        productAddressRepository.deleteById(id);
    }

    @Override
    public List<ProductAddress> allProductAddresses() {
        return (List<ProductAddress>) productAddressRepository.findAll();
    }

    @Override
    public Optional<ProductAddress> oneProductAddress(Long id) {
        return productAddressRepository.findById(id);
    }


}
