package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.dto.PriceDto;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PriceService {

    void createPrice(PriceDto price);

    void updatePrice(Long id, PriceDto price);

    void deletePrice(Long id);

    PriceDto onePriceDto(Long id);

    //Paginated Gets

    Page<PriceDto> getPaginatedPricesDto(Pageable pageable);

    Page<PriceDto> getPaginatedPriceProductIdDto(long id, Pageable pageable);

    Page<PriceDto> getPaginatedPriceProductIdLast7DaysDto(long id, Pageable pageable);

    Page<PriceDto> getDailyPrices(long id, Pageable pageable);

}