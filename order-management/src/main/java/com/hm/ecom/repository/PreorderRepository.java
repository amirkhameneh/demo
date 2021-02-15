package com.hm.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.hm.ecom.model.Preorder;


public interface PreorderRepository extends CrudRepository<Preorder, Long>{
	@Query("SELECT u FROM Preorder u WHERE u.domain = :domain AND u.center = :center AND u.customer = :customer AND u.orderSt = 10")
	List<Preorder> findLastCart(@Param("domain") Long domain  ,@Param("center") Long center  ,@Param("customer") Long customer);
	
	@Query(value ="SELECT ID FROM orm_preorders u WHERE u.srl = :srl", nativeQuery = true)
	String findID(@Param("srl") Long srl);
	
	@Query(value ="SELECT srl FROM orm_preorders u WHERE u.id = :id", nativeQuery = true)
	Long getSrlById(@Param("id") String id);
}
//
//