package com.tracker.ProductPriceTrackingSystem.service.impl;

import com.tracker.ProductPriceTrackingSystem.model.Price;
import com.tracker.ProductPriceTrackingSystem.model.Product;
import com.tracker.ProductPriceTrackingSystem.repository.PriceRepository;
import com.tracker.ProductPriceTrackingSystem.repository.ProductRepository;
import com.tracker.ProductPriceTrackingSystem.service.PriceService;
import com.tracker.ProductPriceTrackingSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;

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


}
