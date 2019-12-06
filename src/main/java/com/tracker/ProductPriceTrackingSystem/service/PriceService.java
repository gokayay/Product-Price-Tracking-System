package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PriceService {

    void createPrice(Price price);

    void updatePrice(Long id, Price price);

    void deletePrice(Long id);

    List<Price> allPrices();

    Optional<Price> onePrice(Long id);

}