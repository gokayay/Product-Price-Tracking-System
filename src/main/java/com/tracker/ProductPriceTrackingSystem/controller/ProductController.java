package com.tracker.ProductPriceTrackingSystem.controller;

import com.tracker.ProductPriceTrackingSystem.dto.ProductDto;
import com.tracker.ProductPriceTrackingSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    // GET

    //for get all products
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Page> findAllPaginatedDto(Pageable pageable) {
        Page<ProductDto> resultPage = productService.getPaginatedProductsDto(pageable);

        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }

    //for get products by search
    @GetMapping("/product-search")
    @ResponseBody
    public ResponseEntity<Page> findAllPaginatedDtoByName(Pageable pageable, @RequestParam(value = "") String product_name) {
        Page<ProductDto> resultPage = productService.getPaginatedProductNameDto(product_name,pageable);

        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }

    //for get one product from db
    @GetMapping ("/{id}")
    public ResponseEntity<ProductDto> getOneProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.oneProductDto(id), HttpStatus.OK);
    }

    // POST

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody @Valid ProductDto product) {
         productService.createProduct(product);
         return new ResponseEntity<>("created", HttpStatus.OK);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable  Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    // PUT

    @PutMapping("/{id}")
    public ResponseEntity<String>  update(@PathVariable  Long id,@RequestBody  ProductDto product){
        productService.updateProduct(id,product);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}