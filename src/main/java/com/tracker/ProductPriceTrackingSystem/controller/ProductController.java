package com.tracker.ProductPriceTrackingSystem.controller;

import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.repository.ProductRepository;
import com.tracker.ProductPriceTrackingSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "")
    public Object getProducts() {
        return productService.allProducts();
    }


    @PostMapping(value = "")
    public String createProduct(@RequestBody  Product product) {
         productService.createProduct(product);
         return "created";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable  Long id) {
        productService.deleteProduct(id);
        return "deleted";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable  Long id,@RequestBody  Product product){
        productService.updateProduct(id,product);
        return "updated";
    }
}