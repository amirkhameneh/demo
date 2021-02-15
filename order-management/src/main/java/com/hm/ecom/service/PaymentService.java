package com.hm.ecom.service;

import com.hm.ecom.model.ZarrinTokenReq;
import com.hm.ecom.model.ZarrinVerifyReq;

public interface PaymentService {
	public String zarrinGetAuthority(ZarrinTokenReq zarrinTokenReq);
	public String zarrinVerify(ZarrinVerifyReq zarrinVerifyReq);
}
