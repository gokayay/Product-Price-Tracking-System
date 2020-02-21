package com.tracker.ProductPriceTrackingSystem.service.impl;

import com.tracker.ProductPriceTrackingSystem.dto.ProductAddressDto;
import com.tracker.ProductPriceTrackingSystem.exception.ObjectNotFoundException;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import com.tracker.ProductPriceTrackingSystem.repository.ProductAddressRepository;
import com.tracker.ProductPriceTrackingSystem.service.ProductAddressService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public void createProductAddress(ProductAddressDto productAddress) {

        try {
            productAddressRepository.save(convertToEntity(productAddress));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProductAddress(Long id, ProductAddressDto productAddress) {
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


    // GET

    @Override
    public ProductAddressDto oneProductAddressDto(Long id) {
        return convertToDto(productAddressRepository.findById(id));
    }

    @Override
    public Page<ProductAddressDto> getPaginatedProductAddressesDto(Pageable pageable) {
        Page<ProductAddressDto> resultPage = convertToDtoPage(productAddressRepository.findAll(pageable));
        return resultPage;
    }

    @Override
    public Page<ProductAddressDto> getPaginatedProductPathDto(String product_path, Pageable pageable) {
        Page<ProductAddressDto> resultPage = convertToDtoPage(productAddressRepository.findAllByNameContaining(product_path,pageable));
        return resultPage;
    }


    // CONVERTING DTO-ENTITY

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

    public Page<ProductAddressDto> convertToDtoPage(Page<ProductAddress> productAddress) {
        Type listType = new TypeToken<Page<ProductAddressDto>>() {}.getType();
        // Convert List of Entity objects to a List of DTOs objects
        Page<ProductAddressDto> returnValue = new ModelMapper().map(productAddress, listType);
        return returnValue;
    }
}
