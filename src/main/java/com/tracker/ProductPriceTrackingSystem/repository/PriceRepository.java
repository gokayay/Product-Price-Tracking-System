package com.tracker.ProductPriceTrackingSystem.repository;

import com.tracker.ProductPriceTrackingSystem.model.ECommerceSite;
import com.tracker.ProductPriceTrackingSystem.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price,Long> {

   Optional<Price> findById(Long id);
  // Optional<Price> findByOtherIds(Long id, Long productId, Long siteId);
}
