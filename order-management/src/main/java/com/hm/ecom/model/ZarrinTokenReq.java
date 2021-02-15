package com.hm.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ZarrinTokenReq {
	String merchantID;
	Long amount;
	String callbackURL;
	String mobile;
	String description;
	
}
