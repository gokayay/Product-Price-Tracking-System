package com.tracker.ProductPriceTrackingSystem.repository;

import com.tracker.ProductPriceTrackingSystem.model.Price;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price,Long> {

   Optional<Price> findById(Long id);

   Page<Price> findAll(Pageable pageable);
/*
   @Query(value = "select * from prices, products where lower(product_name) like lower(concat('%',:product_name,'%')) ", nativeQuery = true)
   Page<Price> findAllByNameContaining(String product_name, Pageable pageable);*/
}
