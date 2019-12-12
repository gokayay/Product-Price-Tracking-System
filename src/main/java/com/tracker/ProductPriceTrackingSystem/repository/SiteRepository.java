package com.tracker.ProductPriceTrackingSystem.repository;

import com.tracker.ProductPriceTrackingSystem.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiteRepository extends JpaRepository<Site,Long> {

   Optional<Site> findById(Long id);
}
