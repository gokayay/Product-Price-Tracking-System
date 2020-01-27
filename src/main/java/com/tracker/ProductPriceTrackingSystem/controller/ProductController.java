package com.tracker.ProductPriceTrackingSystem.controller;

import com.tracker.ProductPriceTrackingSystem.dto.ProductDto;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
/*
    @GetMapping(value = "")
    public ResponseEntity<List<ProductDto>> getProducts() {
        return new ResponseEntity<>(productService.allProductsDto(), HttpStatus.OK);
    }
*/

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<ProductDto>> findAllPaginatedDto(Pageable pageable) {
        Page<ProductDto> resultPage = productService.getPaginatedProductsDto(pageable);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Total Page", String.valueOf(resultPage.getTotalPages()));
        headers.add("Total Size", String.valueOf(resultPage.getTotalElements()));

        return new ResponseEntity<>(resultPage.getContent(),headers, HttpStatus.OK);
    }

    @GetMapping("/productname")
    @ResponseBody
    public ResponseEntity<List<ProductDto>> findAllPaginatedDtoByName(Pageable pageable, @RequestParam String product_name) {
        Page<ProductDto> resultPage = productService.getPaginatedProductNameDto(product_name,pageable);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Total Page", String.valueOf(resultPage.getTotalPages()));
        headers.add("Total Size", String.valueOf(resultPage.getTotalElements()));

        return new ResponseEntity<>(resultPage.getContent(),headers, HttpStatus.OK);
    }


    @GetMapping ("/{id}")
    public ResponseEntity<ProductDto> getOneProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.oneProductDto(id), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody @Valid Product product) {
         productService.createProduct(product);
         return new ResponseEntity<>("created", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable  Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>  update(@PathVariable  Long id,@RequestBody  Product product){
        productService.updateProduct(id,product);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}