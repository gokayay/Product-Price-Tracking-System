package com.tracker.ProductPriceTrackingSystem.controller;

import com.tracker.ProductPriceTrackingSystem.dto.ProductAddressDto;
import com.tracker.ProductPriceTrackingSystem.service.ProductAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/productaddress")
public class ProductAddressController {

    @Autowired
    ProductAddressService productAddressService;

    // GET

    //for get all product addresses
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Page> findAllPaginatedDto(Pageable pageable) {
        Page<ProductAddressDto> resultPage = productAddressService.getPaginatedProductAddressesDto(pageable);

        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }

    //for get product addresses by search
    @GetMapping("/product-address-search")
    @ResponseBody
    public ResponseEntity<Page> findAllPaginatedDtoByName(Pageable pageable, @RequestParam(value = "") String product_path) {
        Page<ProductAddressDto> resultPage = productAddressService.getPaginatedProductPathDto(product_path,pageable);

        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }

    //for get only one product address from db
    @GetMapping ("/{id}")
    public ResponseEntity<ProductAddressDto> getOneProductAddress(@PathVariable Long id){
        return new ResponseEntity<>(productAddressService.oneProductAddressDto(id), HttpStatus.OK);
    }

    // POST

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody ProductAddressDto productAddress) {
        productAddressService.createProductAddress(productAddress);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable  Long id) {
        productAddressService.deleteProductAddress(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    // PUT

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable  Long id,@RequestBody  ProductAddressDto productAddress){
        productAddressService.updateProductAddress(id,productAddress);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}