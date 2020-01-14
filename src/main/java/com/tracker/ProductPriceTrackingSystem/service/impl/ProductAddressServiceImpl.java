package com.tracker.ProductPriceTrackingSystem.service.impl;


import com.tracker.ProductPriceTrackingSystem.dto.PriceDto;
import com.tracker.ProductPriceTrackingSystem.dto.ProductAddressDto;
import com.tracker.ProductPriceTrackingSystem.exception.ObjectNotFoundException;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import com.tracker.ProductPriceTrackingSystem.repository.ProductAddressRepository;
import com.tracker.ProductPriceTrackingSystem.service.ProductAddressService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductAddressServiceImpl implements ProductAddressService {

    @Autowired
    ProductAddressRepository productAddressRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void createProductAddress(ProductAddress productAddress) {

        productAddressRepository.save(productAddress);
    }


    @Override
    public void updateProductAddress(Long id, ProductAddress productAddress) {
        Optional<ProductAddress> existedProductAddress = productAddressRepository.findById(id);

        if (!existedProductAddress.isPresent())
            throw new ObjectNotFoundException("Product address not found");

        ProductAddress exProductAddress = existedProductAddress.get();
        exProductAddress.setProductPath(productAddress.getProductPath());
        //exProductAddress.setProduct(productAddress.getProduct());
        //exProductAddress.setSite(productAddress.getSite());

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


    @Override
    public List<ProductAddressDto> allProductAddressesDto() {
        return convertToDto(productAddressRepository.findAll());
    }

    @Override
    public ProductAddressDto oneProductAddressDto(Long id) {
        return convertToDto(productAddressRepository.findById(id));
    }


    //////////

    private ProductAddressDto convertToDto(Optional<ProductAddress> productAddress) {
        return modelMapper.map(productAddress.get(), ProductAddressDto.class);
    }

    private List<ProductAddressDto> convertToDto(List<ProductAddress> productAddress) {
        // Create Conversion Type
        Type listType = new TypeToken<List<ProductAddressDto>>() {}.getType();
        // Convert List of Entity objects to a List of DTOs objects
        List<ProductAddressDto> returnValue = new ModelMapper().map(productAddress, listType);
        return returnValue;
    }


    private ProductAddress convertToEntity(ProductAddressDto productAddressDto) throws ParseException {

        return modelMapper.map(productAddressDto, ProductAddress.class);
    }
}
