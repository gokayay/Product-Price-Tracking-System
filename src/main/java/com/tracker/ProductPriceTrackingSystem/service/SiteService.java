package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.dto.SiteDto;
import com.tracker.ProductPriceTrackingSystem.model.Site;

import java.util.List;
import java.util.Optional;

public interface SiteService {

    void createSite(Site site);

    void updateSite(Long id, Site site);

    void deleteSite(long id);

    List<Site> allSites();

    Optional<Site> oneSite(Long id);

    List<SiteDto> allSitesDto();

    SiteDto oneSiteDto(Long id);
}