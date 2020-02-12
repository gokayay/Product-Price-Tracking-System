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

   @Query(value = "select * from prices where product_id=:product_id and date > current_date - interval '20 days'", nativeQuery = true)
   Page<Price> findAllByProductIdLast7Days(Long product_id, Pageable pageable);

   @Query(value = "select * from (select distinct on (site_id)site_id,* from prices where product_id=:product_id and date > current_date - interval '24 hours' order by site_id, date desc) t order by price ", nativeQuery = true)
   Page<Price> findDailyPrices(Long product_id, Pageable pageable);

}
