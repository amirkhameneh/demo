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
public class ProductDetailResponse {
	String name;
	String lname;
	String brand;
	String supplier;
	Long qty;
	Long prePrice;
	Long postPrice;
	String description;
	int rate;
	String mainImage;
	List<String> images;
	List<ProductAttributeView> attributes;
	List<ProductImage> otherImages; 
	List<ProductClass> productClasses; 
	
	
	
}
