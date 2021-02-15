package com.hm.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hm.ecom.model.Filter;
import com.hm.ecom.model.ProductImage;

public interface ProductImageRepository  extends CrudRepository<ProductImage, Long>{
		
		@Query("SELECT u FROM ProductImage u WHERE u.srl = :srl ")
		List<ProductImage> findAllBySrl(@Param("srl") Long srl);
		
}
