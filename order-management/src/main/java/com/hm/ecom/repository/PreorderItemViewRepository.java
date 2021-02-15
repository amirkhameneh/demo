package com.hm.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hm.ecom.model.PreorderItemView;

public interface PreorderItemViewRepository extends CrudRepository<PreorderItemView, Long>{
	@Query("SELECT u FROM PreorderItemView u WHERE u.preorder = :preorder " )
	List<PreorderItemView> getOrderItems(@Param("preorder") String preorder);
}
