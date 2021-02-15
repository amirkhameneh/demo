package com.hm.ecom.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductListRequestModel {
	long domain;
	long category;
	long campaign;
	long center; 
	int pageSize;
	int pageNo;
	String sort;
	List<SelectedFilter> selectedFilters; 
}
