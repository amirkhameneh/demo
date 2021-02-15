package com.hm.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.hm.ecom.model.Filter;
import com.hm.ecom.model.User;

public interface FilterRepository extends CrudRepository<Filter, String>{
	
	@Query("SELECT u FROM Filter u WHERE u.companyId = :company AND ( u.category = :category OR u.category=-1) ORDER BY  u.order ")
	List<Filter> findAllByCompanyAndCategory(@Param("company") Long company,@Param("category") Long category);
	
	
/*	User findByEmailAndCompanyId(String email, Long companyId);

    User findByUserIdAndCompanyId(String userId, Long companyId);
    
    @Query("SELECT u FROM User u WHERE u.email = :email AND u.companyId = :companyId")
    User findByEmail(@Param("email") String email, @Param("companyId") long companyId);
*/    
}



