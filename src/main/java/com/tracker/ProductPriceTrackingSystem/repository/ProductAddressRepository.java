package com.tracker.ProductPriceTrackingSystem.repository;

import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductAddressRepository extends JpaRepository<ProductAddress,Long> {

    Optional<ProductAddress> findById(Long id);

    Page<ProductAddress> findAll(Pageable pageable);
}