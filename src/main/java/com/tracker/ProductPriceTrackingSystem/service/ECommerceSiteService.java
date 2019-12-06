package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.model.ECommerceSite;
import com.tracker.ProductPriceTrackingSystem.model.Product;

import java.util.List;

public interface ECommerceSiteService {

    void createSite(ECommerceSite eCommerceSite);

    void updateSite(Long id, ECommerceSite eCommerceSite);

    void deleteSite(long id);

    List<ECommerceSite> allSites();

}