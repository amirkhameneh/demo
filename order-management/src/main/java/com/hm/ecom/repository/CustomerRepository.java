package com.hm.ecom.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hm.ecom.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, String>{
	List<Customer> findByUserSrl(  Long userSrl );
}
