package com.tracker.ProductPriceTrackingSystem.repository;

import com.tracker.ProductPriceTrackingSystem.constants.SqlConstants;
import com.tracker.ProductPriceTrackingSystem.model.ProductAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductAddressRepository extends JpaRepository<ProductAddress,Long> {

    Optional<ProductAddress> findById(Long id);

    Page<ProductAddress> findAll(Pageable pageable);

    @Query(value = SqlConstants.ProductAddressQuery.GetBySearch, nativeQuery = true)
    Page<ProductAddress> findAllByNameContaining(String product_path, Pageable pageable);
}