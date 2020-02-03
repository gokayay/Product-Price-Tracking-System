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

   @Query(value = "select * from prices where product_id=:product_id ", nativeQuery = true)
   Page<Price> findAllByProductId(Long product_id, Pageable pageable);


}
