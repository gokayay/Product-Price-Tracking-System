package com.tracker.ProductPriceTrackingSystem.service.impl;

import com.tracker.ProductPriceTrackingSystem.model.Site;
import com.tracker.ProductPriceTrackingSystem.repository.SiteRepository;
import com.tracker.ProductPriceTrackingSystem.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    SiteRepository siteRepository;

    @Override
    public void createSite(Site site) {

        siteRepository.save(site);
    }

    @Override
    public void updateSite(Long id, Site site) {
        Optional<Site> existedSite = siteRepository.findById(id);

        if (!existedSite.isPresent())
            throw new UnsupportedOperationException("E-commerce site not found");
        Site exSite = existedSite.get();
        siteRepository.save(exSite);
    }


    @Override
    public void deleteSite(long id) {

        siteRepository.deleteById(id);
    }

    @Override
    public List<Site> allSites() {
        return (List<Site>) siteRepository.findAll();
    }

    @Override
    public Optional<Site> oneSite(Long id) {
        return siteRepository.findById(id);
    }


}
