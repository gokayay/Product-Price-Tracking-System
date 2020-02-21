package com.tracker.ProductPriceTrackingSystem.controller;

import com.tracker.ProductPriceTrackingSystem.dto.PriceDto;
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

    // GET

    //for get all prices
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Page> findAllPaginatedDto(Pageable pageable) {
        Page<PriceDto> resultPage = priceService.getPaginatedPricesDto(pageable);
        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }

    //for get specific prices by product
    @GetMapping("/prices-by-product/{id}")
    @ResponseBody
    public ResponseEntity<Page> findAllPaginatedDtoByProductId(@PathVariable long id,Pageable pageable) {
        Page<PriceDto> resultPage = priceService.getPaginatedPriceProductIdDto(id,pageable);

        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }

    //for get prices from 20 days ago
    @GetMapping("/prices-by-product-last-20-days/{id}")
    @ResponseBody
    public ResponseEntity<Page> findAllPaginatedDtoByProductIdLast20Days(@PathVariable long id,Pageable pageable) {
        Page<PriceDto> resultPage = priceService.getPaginatedPriceProductIdLast7DaysDto(id,pageable);

        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }

    //for get only today's prices by a product
    @GetMapping("/daily-prices/{id}")
    @ResponseBody
    public ResponseEntity<Page> findAllDailyPrices(@PathVariable long id, Pageable pageable) {
        Page<PriceDto> resultPage = priceService.getDailyPrices(id,pageable);

        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }

    //for get one price from price db
    @GetMapping ("/{id}")
    public ResponseEntity<PriceDto> getOnePrice(@PathVariable Long id){
        return new ResponseEntity<>(priceService.onePriceDto(id), HttpStatus.OK) ;
    }

    // POST

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody PriceDto price) {
        priceService.createPrice(price);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable  Long id) {
        priceService.deletePrice(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    // PUT

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable  Long id,@RequestBody  PriceDto price){
        priceService.updatePrice(id,price);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }

}
