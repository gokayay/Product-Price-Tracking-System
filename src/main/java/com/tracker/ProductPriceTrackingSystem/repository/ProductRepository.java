package com.tracker.ProductPriceTrackingSystem.repository;

import com.tracker.ProductPriceTrackingSystem.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

   Optional<Product> findById(Long id);

   Page<Product> findAll(Pageable pageable);

   @Query(value = "select * from products where product_name like %:product_name%", nativeQuery = true)
   Page<Product> findAllByNameContaining(String product_name, Pageable pageable);

}
