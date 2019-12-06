package com.tracker.ProductPriceTrackingSystem.repository;

import com.tracker.ProductPriceTrackingSystem.model.ECommerceSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ECommerceSiteRepository extends JpaRepository<ECommerceSite,Long> {

   Optional<ECommerceSite> findById(Long id);
}
