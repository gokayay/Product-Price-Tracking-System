package com.tracker.ProductPriceTrackingSystem.service.impl;

import com.tracker.ProductPriceTrackingSystem.model.ECommerceSite;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.repository.ECommerceSiteRepository;
import com.tracker.ProductPriceTrackingSystem.service.ECommerceSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ECommerceSiteServiceImpl implements ECommerceSiteService {

    @Autowired
    ECommerceSiteRepository eCommerceSiteRepository;

    @Override
    public void createSite(ECommerceSite eCommerceSite) {

        eCommerceSiteRepository.save(eCommerceSite);
    }

    @Override
    public void updateSite(Long id, ECommerceSite eCommerceSite) {
        Optional<ECommerceSite> existedSite = eCommerceSiteRepository.findById(id);

        if (!existedSite.isPresent())
            throw new UnsupportedOperationException("E-commerce site not found");
        ECommerceSite exSite = existedSite.get();
        exSite.setSiteName(eCommerceSite.getSiteName());
        exSite.setSiteXpath(eCommerceSite.getSiteXpath());
        eCommerceSiteRepository.save(exSite);
    }


    @Override
    public void deleteSite(long id) {

        eCommerceSiteRepository.deleteById(id);
    }

    @Override
    public List<ECommerceSite> allSites() {
        return (List<ECommerceSite>) eCommerceSiteRepository.findAll();
    }

    @Override
    public Optional<ECommerceSite> oneSite(Long id) {
        return eCommerceSiteRepository.findById(id);
    }


}
