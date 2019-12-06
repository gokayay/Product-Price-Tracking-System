package com.tracker.ProductPriceTrackingSystem.controller;

import com.tracker.ProductPriceTrackingSystem.model.ECommerceSite;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.service.ECommerceSiteService;
import com.tracker.ProductPriceTrackingSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommercesite")
public class ECommerceSiteController {

    @Autowired
    ECommerceSiteService eCommerceSiteService;

    @GetMapping(value = "")
    public Object getProducts() {
        return eCommerceSiteService.allSites();
    }

    @GetMapping ("/{id}")
    public Object getOneSite(@PathVariable Long id){
        return eCommerceSiteService.oneSite(id);
    }

    @PostMapping(value = "")
    public String createProduct(@RequestBody  ECommerceSite eCommerceSite) {
        eCommerceSiteService.createSite(eCommerceSite);
         return "created";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable  Long id) {
        eCommerceSiteService.deleteSite(id);
        return "deleted";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable  Long id,@RequestBody  ECommerceSite eCommerceSite){
        eCommerceSiteService.updateSite(id,eCommerceSite);
        return "updated";
    }
}