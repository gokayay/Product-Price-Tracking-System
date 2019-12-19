package com.tracker.ProductPriceTrackingSystem.service.impl;

import com.tracker.ProductPriceTrackingSystem.dto.PriceDto;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.repository.PriceRepository;
import com.tracker.ProductPriceTrackingSystem.service.PriceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void createPrice(Price price) {
        priceRepository.save(price);
    }

    @Override
    public void updatePrice(Long id, Price price) {
        Optional<Price> existedPrice = priceRepository.findById(id);

        if (!existedPrice.isPresent())
            throw new UnsupportedOperationException("Price not found");

        Price exPrice = existedPrice.get();

        exPrice.setProduct(price.getProduct());
        exPrice.setSite(price.getSite());
        exPrice.setDate(price.getDate());
        exPrice.setPrice(price.getPrice());

        priceRepository.save(exPrice);
    }


    @Override
    public void deletePrice(Long id) {

        priceRepository.deleteById(id);
    }

    @Override
    public List<Price> allPrices() {
        return (List<Price>) priceRepository.findAll();
    }

    @Override
    public Optional<Price> onePrice(Long id) {
        return priceRepository.findById(id);
    }

    @Override
    public List<PriceDto> allPricesDto() {
        return convertToDto(priceRepository.findAll());
    }

    @Override
    public PriceDto onePriceDto(Long id) {
        return convertToDto(priceRepository.findById(id));
    }


    //////////

    private PriceDto convertToDto(Optional<Price> price) {
        return modelMapper.map(price.get(), PriceDto.class);
    }

    private List<PriceDto> convertToDto(List<Price> price) {
        // Create Conversion Type
        Type listType = new TypeToken<List<PriceDto>>() {}.getType();
        // Convert List of Entity objects to a List of DTOs objects
        List<PriceDto> returnValue = new ModelMapper().map(price, listType);
        return returnValue;
    }


    private Price convertToEntity(PriceDto priceDto) throws ParseException {

        return modelMapper.map(priceDto, Price.class);
    }
}
