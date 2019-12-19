package com.tracker.ProductPriceTrackingSystem.service.impl;

import com.tracker.ProductPriceTrackingSystem.dto.SiteDto;
import com.tracker.ProductPriceTrackingSystem.exception.ObjectNotFoundException;
import com.tracker.ProductPriceTrackingSystem.model.Site;
import com.tracker.ProductPriceTrackingSystem.repository.SiteRepository;
import com.tracker.ProductPriceTrackingSystem.service.SiteService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    SiteRepository siteRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void createSite(Site site) {

        siteRepository.save(site);
    }

    @Override
    public void updateSite(Long id, Site site) {
        Optional<Site> existedSite = siteRepository.findById(id);

        if (!existedSite.isPresent()) throw new ObjectNotFoundException("E-commerce site not found");
        Site exSite = existedSite.get();

        exSite.setSiteName(site.getSiteName());
        exSite.setSiteUrl(site.getSiteUrl());
        exSite.setSiteXpath(site.getSiteXpath());

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

    @Override
    public List<SiteDto> allSitesDto() {
        return convertToDto(siteRepository.findAll());
    }

    @Override
    public SiteDto oneSiteDto(Long id) {
        return convertToDto(siteRepository.findById(id));
    }

//////////

    private SiteDto convertToDto(Optional<Site> site) {
        return modelMapper.map(site.get(), SiteDto.class);
    }

    private List<SiteDto> convertToDto(List<Site> site) {
        // Create Conversion Type
        Type listType = new TypeToken<List<SiteDto>>() {}.getType();
        // Convert List of Entity objects to a List of DTOs objects
        List<SiteDto> returnValue = new ModelMapper().map(site, listType);
        return returnValue;
    }


    private Site convertToEntity(SiteDto siteDto) throws ParseException {

        return modelMapper.map(siteDto, Site.class);
    }
}
