package com.tracker.ProductPriceTrackingSystem.controller;

import com.tracker.ProductPriceTrackingSystem.dto.PriceDto;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.service.PriceService;
import com.tracker.ProductPriceTrackingSystem.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/price")
public class PriceController {


    @Autowired
    PriceService priceService;

    @GetMapping(value = "")
    public ResponseEntity<List<PriceDto>> getPrices() {
        return new ResponseEntity<>(priceService.allPricesDto(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<PriceDto> getOnePrice(@PathVariable Long id){
        return new ResponseEntity<>(priceService.onePriceDto(id), HttpStatus.OK) ;
    }

    @PostMapping(value = "")
    public ResponseEntity<String> createPrices(@RequestBody Price price) {
        priceService.createPrice(price);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable  Long id) {
        priceService.deletePrice(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable  Long id,@RequestBody  Price price){
        priceService.updatePrice(id,price);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }

}
