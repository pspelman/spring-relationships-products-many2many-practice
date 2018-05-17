//package com.philspelman.springrelationshipsproductsm2m.repositories;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//
//@Repository
//public interface CategoryProductJPARepo extends JpaRepository {
//
//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "ALTER TABLE categories_products DROP PRIMARY KEY, ADD PRIMARY KEY(category_id, product_id)", nativeQuery = true)
//    void changeTables();
//
//
//}
