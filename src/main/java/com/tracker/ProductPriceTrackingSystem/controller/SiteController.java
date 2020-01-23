package com.tracker.ProductPriceTrackingSystem.controller;

import com.tracker.ProductPriceTrackingSystem.dto.ProductDto;
import com.tracker.ProductPriceTrackingSystem.dto.SiteDto;
import com.tracker.ProductPriceTrackingSystem.model.Site;
import com.tracker.ProductPriceTrackingSystem.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/site")
public class SiteController {

    @Autowired
    SiteService siteService;

    /*
    @GetMapping(value = "")
    public ResponseEntity<List<SiteDto>> getSites()
    {
        return new ResponseEntity<>(siteService.allSitesDto(), HttpStatus.OK);
    }*/

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<SiteDto>> findAllPaginatedDto(Pageable pageable ,
                                                                @RequestParam(defaultValue = "0", name = "page") String page,
                                                                @RequestParam(defaultValue = "3", name = "size") String size,
                                                                @RequestParam(defaultValue = "id,ASC", name = "sort") String sort) {
        Page<SiteDto> resultPage = siteService.getPaginatedSitesDto(pageable);
        return new ResponseEntity<>(resultPage.getContent(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<SiteDto> getOneSite(@PathVariable Long id){
        return new ResponseEntity<>(siteService.oneSiteDto(id), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody Site site) {
        siteService.createSite(site);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable  Long id) {
        siteService.deleteSite(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable  Long id,@RequestBody Site site){
        siteService.updateSite(id, site);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}