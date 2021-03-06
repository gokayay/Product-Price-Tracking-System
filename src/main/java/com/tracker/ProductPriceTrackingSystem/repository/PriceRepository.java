package com.tracker.ProductPriceTrackingSystem.repository;

import com.tracker.ProductPriceTrackingSystem.constants.SqlConstants;


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

   @Query(value = SqlConstants.PriceQuery.GetByProductId, nativeQuery = true)
   Page<Price> findAllByProductId(Long product_id, Pageable pageable);

   @Query(value = SqlConstants.PriceQuery.GetByProductIdLast20Days, nativeQuery = true)
   Page<Price> findAllByProductIdLast7Days(Long product_id, Pageable pageable);

   @Query(value = SqlConstants.PriceQuery.GetDailyPrices, nativeQuery = true)
   Page<Price> findDailyPrices(Long product_id, Pageable pageable);

}
