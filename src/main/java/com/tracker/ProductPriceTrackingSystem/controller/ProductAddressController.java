package com.tracker.ProductPriceTrackingSystem.controller;

import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import com.tracker.ProductPriceTrackingSystem.service.ProductAddressService;
import com.tracker.ProductPriceTrackingSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productaddress")
public class ProductAddressController {

    @Autowired
    ProductAddressService productAddressService;

    @GetMapping(value = "")
    public Object getProductAddress() {
        return productAddressService.allProductAddresses();
    }

    @GetMapping ("/{id}")
    public Object getOneProductAddress(@PathVariable Long id){
        return productAddressService.oneProductAddress(id);
    }

    @PostMapping(value = "")
    public String create(@RequestBody ProductAddress productAddress) {
        productAddressService.createProductAddress(productAddress);
        return "created";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable  Long id) {
        productAddressService.deleteProductAddress(id);
        return "deleted";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable  Long id,@RequestBody  ProductAddress productAddress){
        productAddressService.updateProductAddress(id,productAddress);
        return "updated";
    }
}