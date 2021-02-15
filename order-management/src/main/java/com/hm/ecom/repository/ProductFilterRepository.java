package com.hm.ecom.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hm.ecom.model.ProductFilter;


public interface ProductFilterRepository extends PagingAndSortingRepository<ProductFilter, Long>, JpaSpecificationExecutor<ProductFilter>{

}
