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
            throw new UnsupportedOperationException("Yok bole bısey");
        Product exProcduct = existedProduct.get();
        exProcduct.setProductComment(product.getProductComment());
        productRepository.save(exProcduct);
    }


    @Override
    public void deleteProduct(long id) {

        productRepository.deleteById(id);
    }

    @Override
    public List<Product> allProducts() {
        return (List<Product>) productRepository.findAll();
    }


}
