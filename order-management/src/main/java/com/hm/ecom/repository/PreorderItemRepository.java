package com.hm.ecom.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hm.ecom.model.PreorderItem;

public interface PreorderItemRepository extends CrudRepository<PreorderItem, Long>{
	@Query(value ="SELECT min(srl) FROM orm_preorderitems u WHERE u.OPOR_SRL = :preorder and u.igod_srl = :product and "
			+ " nvl(SSUP_SRL,-1)= :supplier and to_char(EXPIRE_DATE,'yyyymmdd')||'-' = :exDate ", nativeQuery = true)
	Long getSrlByProduct(@Param("preorder") Long preorder , @Param("product") Long product 
			           , @Param("supplier") Long supplier ,@Param("exDate") String exDate);
}
