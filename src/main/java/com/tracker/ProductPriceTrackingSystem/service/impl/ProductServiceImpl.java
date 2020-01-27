package com.tracker.ProductPriceTrackingSystem.service.impl;

import com.tracker.ProductPriceTrackingSystem.dto.ProductAddressDto;
import com.tracker.ProductPriceTrackingSystem.dto.ProductDto;
import com.tracker.ProductPriceTrackingSystem.exception.ObjectNotFoundException;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import com.tracker.ProductPriceTrackingSystem.repository.ProductRepository;
import com.tracker.ProductPriceTrackingSystem.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void createProduct(Product product) {

        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Optional<Product> existedProduct = productRepository.findById(id);

        if (!existedProduct.isPresent())
            throw new ObjectNotFoundException("Product not found");

        Product exProduct = existedProduct.get();
        exProduct.setProductName(product.getProductName());
        exProduct.setProductComment(product.getProductComment());
        exProduct.setProductImg(product.getProductImg());

        productRepository.save(exProduct);
    }


    @Override
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }

    @Override
    public List<Product> allProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> oneProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductDto> allProductsDto() {
        return convertToDto(productRepository.findAll());
    }

    @Override
    public ProductDto oneProductDto(Long id) {
        return convertToDto(productRepository.findById(id));
    }

    //////////

    private ProductDto convertToDto(Optional<Product> product) {
        return modelMapper.map(product.get(), ProductDto.class);
    }

    private List<ProductDto> convertToDto(List<Product> product) {
        // Create Conversion Type
        Type listType = new TypeToken<List<ProductDto>>() {}.getType();
        // Convert List of Entity objects to a List of DTOs objects
        List<ProductDto> returnValue = new ModelMapper().map(product, listType);
        return returnValue;
    }
    public Page<ProductDto> convertToDtoPage(Page<Product> product) {
        // Create Conversion Type
        Type listType = new TypeToken<Page<ProductDto>>() {}.getType();
        // Convert List of Entity objects to a List of DTOs objects
        Page<ProductDto> returnValue = new ModelMapper().map(product, listType);
        return returnValue;
    }


    private Product convertToEntity(ProductDto productDto) throws ParseException {

        return modelMapper.map(productDto, Product.class);
    }


    /////////
/*
    public Page<Product> getPaginatedProducts(int pageNumber) {
        PageRequest pageable = PageRequest.of(pageNumber - 1, 6);
        Page<Product> resultPage = productRepository.findAll(pageable);
        if (pageNumber > resultPage.getTotalPages()) {
            throw new ObjectNotFoundException("Not Found Page Number:" + pageNumber);
        }
        return resultPage;
    }
*/
    public Page<ProductDto> getPaginatedProductsDto(Pageable pageable) {
        Page<ProductDto> resultPage = convertToDtoPage(productRepository.findAll(pageable));
        return resultPage;
    }

    public Page<ProductDto> getPaginatedProductNameDto(String product_name,Pageable pageable) {
        Page<ProductDto> resultPage = convertToDtoPage(productRepository.findAllByNameContaining(product_name,pageable));
        return resultPage;
    }
}
