package com.tracker.ProductPriceTrackingSystem.service.impl;

import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.repository.ProductRepository;
import com.tracker.ProductPriceTrackingSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {

        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        Optional<Product> existedProduct = productRepository.findById(id);

        if (!existedProduct.isPresent())
            throw new UnsupportedOperationException("Product not found");

        Product exProduct = existedProduct.get();
        exProduct.setProductName(product.getProductName());
        exProduct.setProductComment(product.getProductComment());

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


}
