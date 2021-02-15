package com.hm.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hm.ecom.model.Filter;
import com.hm.ecom.model.ProductDetail;

public interface ProductDetailRepository extends CrudRepository<ProductDetail, String>{
	@Query("SELECT u FROM ProductDetail u WHERE u.srl IN (:products)  ")
	List<ProductDetail> findByProduct(@Param("products") List<Long> products);
	
	@Query("SELECT u FROM ProductDetail u WHERE u.srl = :srl  ")
	ProductDetail findBySrl(@Param("srl") Long srl);
}
