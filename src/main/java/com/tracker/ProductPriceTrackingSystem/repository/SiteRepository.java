package com.tracker.ProductPriceTrackingSystem.repository;

import com.tracker.ProductPriceTrackingSystem.model.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiteRepository extends JpaRepository<Site,Long> {

   Optional<Site> findById(Long id);

   Page<Site> findAll(Pageable pageable);

   @Query(value = "select * from sites where lower(site_name) like lower(concat('%',:site_name,'%')) ", nativeQuery = true)
   Page<Site> findAllByNameContaining(String site_name, Pageable pageable);
}
