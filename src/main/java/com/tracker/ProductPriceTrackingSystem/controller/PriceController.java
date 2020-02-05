package com.tracker.ProductPriceTrackingSystem.controller;

import com.tracker.ProductPriceTrackingSystem.dto.PriceDto;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/price")
public class PriceController {


    @Autowired
    PriceService priceService;
/*
    @GetMapping(value = "")
    public ResponseEntity<List<PriceDto>> getPrices() {
        return new ResponseEntity<>(priceService.allPricesDto(), HttpStatus.OK);
    }*/

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Page> findAllPaginatedDto(Pageable pageable) {
        Page<PriceDto> resultPage = priceService.getPaginatedPricesDto(pageable);
        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }

    @GetMapping("/prices-by-product/{id}")
    @ResponseBody
    public ResponseEntity<Page> findAllPaginatedDtoByProductId(@PathVariable long id,Pageable pageable) {
        Page<PriceDto> resultPage = priceService.getPaginatedPriceProductIdDto(id,pageable);

        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }

    @GetMapping("/prices-by-product-last-7-days/{id}")  // Denemek için client-side'da url değiştirildi!
    @ResponseBody
    public ResponseEntity<Page> findAllPaginatedDtoByProductIdLast7Days(@PathVariable long id,Pageable pageable) {
        Page<PriceDto> resultPage = priceService.getPaginatedPriceProductIdLast7DaysDto(id,pageable);

        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<PriceDto> getOnePrice(@PathVariable Long id){
        return new ResponseEntity<>(priceService.onePriceDto(id), HttpStatus.OK) ;
    }

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody Price price) {
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
