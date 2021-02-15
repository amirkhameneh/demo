package com.hm.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hm.ecom.model.ProductClass;

public interface ProductClassRepository extends CrudRepository<ProductClass, Long>{
		
		@Query("SELECT u FROM ProductClass u WHERE u.parent = :parent ")
		List<ProductClass> findAllByParent(@Param("parent") Long parent);
}
