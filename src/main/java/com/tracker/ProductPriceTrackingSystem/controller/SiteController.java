package com.tracker.ProductPriceTrackingSystem.controller;

import com.tracker.ProductPriceTrackingSystem.model.Site;
import com.tracker.ProductPriceTrackingSystem.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/site")
public class SiteController {

    @Autowired
    SiteService siteService;

    @GetMapping(value = "")
    public Object getProducts() {
        return siteService.allSites();
    }

    @GetMapping ("/{id}")
    public Object getOneSite(@PathVariable Long id){
        return siteService.oneSite(id);
    }

    @PostMapping(value = "")
    public String createProduct(@RequestBody Site site) {
        siteService.createSite(site);
         return "created";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable  Long id) {
        siteService.deleteSite(id);
        return "deleted";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable  Long id,@RequestBody Site site){
        siteService.updateSite(id, site);
        return "updated";
    }
}