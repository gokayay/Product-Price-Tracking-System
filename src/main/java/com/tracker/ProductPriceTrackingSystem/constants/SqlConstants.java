package com.tracker.ProductPriceTrackingSystem.constants;

public interface SqlConstants {

    interface PriceQuery {

        final String GetByProductId = "select * from prices where product_id=:product_id";
        final String GetByProductIdLast20Days = "select * from prices where product_id=:product_id and date > current_date - interval '20 days'";
        final String GetDailyPrices = "select * from (select distinct on (site_id)site_id,* from prices where product_id=:product_id and date > current_date - interval '24 hours' order by site_id, date desc) t order by price";
    }

    interface ProductAddressQuery {

        final String GetBySearch = "select * from product_addresses where lower(product_path) like lower(concat('%',:product_path,'%')) ";
    }

    interface ProductQuery{

        final String GetBySearch ="select * from products where lower(product_name) like lower(concat('%',:product_name,'%')) ";
    }

    interface SiteQuery{

        final String GetBySearch ="select * from sites where lower(site_name) like lower(concat('%',:site_name,'%')) ";
    }
}
