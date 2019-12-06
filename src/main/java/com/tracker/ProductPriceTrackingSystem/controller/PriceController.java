package com.tracker.ProductPriceTrackingSystem.controller;

import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.service.PriceService;
import com.tracker.ProductPriceTrackingSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
public class PriceController {


    @Autowired
    PriceService priceService;

    @GetMapping(value = "")
    public Object getPrices() {
        return priceService.allPrices();
    }

    @PostMapping(value = "")
    public String createPrices(@RequestBody Price price) {
        priceService.createPrice(price);
        return "created";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable  Long id) {
        priceService.deletePrice(id);
        return "deleted";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable  Long id,@RequestBody  Price price){
        priceService.updatePrice(id,price);
        return "updated";
    }
}
