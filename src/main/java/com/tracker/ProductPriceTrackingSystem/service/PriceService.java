package com.tracker.ProductPriceTrackingSystem.service;

import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.model.Product;

import java.util.List;

public interface PriceService {

    void createPrice(Price price);

    void updatePrice(Long id, Price price);

    void deletePrice(long id);

    List<Price> allPrices();

}