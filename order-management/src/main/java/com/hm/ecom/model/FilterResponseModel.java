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
public class FilterResponseModel {
	Long id;
	String code;
	String name;
	String type;
	Long   order;
	List<Option> options; 
	
	
}
