package com.hm.ecom.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hm.ecom.model.User;
import com.hm.ecom.model.UserToken;

public interface UserTokenRepository extends CrudRepository<UserToken, String> {
	UserToken findBytoken(String token);
}
