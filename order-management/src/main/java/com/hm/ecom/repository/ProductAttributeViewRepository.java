package com.hm.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hm.ecom.model.ProductAttributeList;
import com.hm.ecom.model.ProductAttributeView;
import com.hm.ecom.model.User;
import com.hm.ecom.model.UserToken;

public interface ProductAttributeViewRepository extends CrudRepository<ProductAttributeView, Long> {
	List<ProductAttributeView> findByProduct(  Long product );
}
