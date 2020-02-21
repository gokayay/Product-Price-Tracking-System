package com.tracker.ProductPriceTrackingSystem.service.impl;

import com.tracker.ProductPriceTrackingSystem.dto.PriceDto;
import com.tracker.ProductPriceTrackingSystem.exception.ObjectNotFoundException;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.repository.PriceRepository;
import com.tracker.ProductPriceTrackingSystem.service.PriceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void createPrice(PriceDto price) {
        try {
            priceRepository.save(convertToEntity(price));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePrice(Long id, PriceDto price) {
        Optional<Price> existedPrice = priceRepository.findById(id);

        if (!existedPrice.isPresent())
            throw new ObjectNotFoundException("Price not found");

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


    // GET

    @Override
    public PriceDto onePriceDto(Long id) {
        return convertToDto(priceRepository.findById(id));
    }

    @Override
    public Page<PriceDto> getPaginatedPricesDto(Pageable pageable) {
        Page<PriceDto> resultPage = convertToDtoPage(priceRepository.findAll(pageable));
        return resultPage;
    }

    @Override
    public Page<PriceDto> getPaginatedPriceProductIdDto(long id, Pageable pageable) {
        Page<PriceDto> resultPage = convertToDtoPage(priceRepository.findAllByProductId(id, pageable));
        return resultPage;
    }

    @Override
    public Page<PriceDto> getPaginatedPriceProductIdLast7DaysDto(long id, Pageable pageable) {
        Page<PriceDto> resultPage = convertToDtoPage(priceRepository.findAllByProductIdLast7Days(id, pageable));
        return resultPage;
    }

    @Override
    public Page<PriceDto> getDailyPrices(long id, Pageable pageable) {
        Page<PriceDto> resultPage = convertToDtoPage(priceRepository.findDailyPrices(id,pageable));
        return resultPage;
    }


    // CONVERTING DTO-ENTITY

    private PriceDto convertToDto(Optional<Price> price) {
        return modelMapper.map(price.get(), PriceDto.class);
    }

    private List<PriceDto> convertToDto(List<Price> price) {
        // Create Conversion Type
        Type listType = new TypeToken<List<PriceDto>>() {
        }.getType();
        // Convert List of Entity objects to a List of DTOs objects
        List<PriceDto> returnValue = new ModelMapper().map(price, listType);
        return returnValue;
    }


    private Price convertToEntity(PriceDto priceDto) throws ParseException {

        return modelMapper.map(priceDto, Price.class);
    }


    public Page<PriceDto> convertToDtoPage(Page<Price> price) {
        // Create Conversion Type
        Type listType = new TypeToken<Page<PriceDto>>() {
        }.getType();
        // Convert List of Entity objects to a List of DTOs objects
        Page<PriceDto> returnValue = new ModelMapper().map(price, listType);
        return returnValue;
    }
}