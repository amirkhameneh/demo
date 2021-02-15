package com.hm.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public class AddToCartRequest {
		String preorder;
		Long product;
		Long qty;
		Long supplier;
		String expireDate;

	}

