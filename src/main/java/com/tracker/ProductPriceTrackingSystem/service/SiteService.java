package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.dto.SiteDto;
import com.tracker.ProductPriceTrackingSystem.model.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SiteService {

    void createSite(SiteDto site);

    void updateSite(Long id, SiteDto site);

    void deleteSite(long id);

    SiteDto oneSiteDto(Long id);

    // Paginated Gets

    Page<SiteDto> getPaginatedSitesDto(Pageable pageable);

    Page<SiteDto> getPaginatedSiteNameDto(String site_name, Pageable pageable);
}