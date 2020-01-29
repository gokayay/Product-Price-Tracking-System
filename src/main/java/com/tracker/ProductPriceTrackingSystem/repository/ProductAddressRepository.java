package com.tracker.ProductPriceTrackingSystem.repository;

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

    @Query(value = "select * from product_addresses where lower(product_path) like lower(concat('%',:product_path,'%')) ", nativeQuery = true)
    Page<ProductAddress> findAllByNameContaining(String product_path, Pageable pageable);
}