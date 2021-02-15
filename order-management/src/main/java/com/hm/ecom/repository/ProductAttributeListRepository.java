package com.hm.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hm.ecom.model.ProductAttributeList;
import com.hm.ecom.model.User;

public interface ProductAttributeListRepository  extends PagingAndSortingRepository<ProductAttributeList, String>, JpaSpecificationExecutor<User> {
	List<ProductAttributeList> findByAttribute(  Long attribute );
}
