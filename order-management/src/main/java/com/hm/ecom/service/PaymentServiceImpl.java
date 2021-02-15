package com.hm.ecom.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hm.ecom.model.ZarrinTokenReq;
import com.hm.ecom.model.ZarrinVerifyReq;

@Component
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override 
	public String zarrinGetAuthority(ZarrinTokenReq zarrinTokenReq) {
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    Map<String, Object> map = new HashMap<>();
		map.put("MerchantID", zarrinTokenReq.getMerchantID());
		map.put("Amount", zarrinTokenReq.getAmount());
		map.put("CallbackURL", zarrinTokenReq.getCallbackURL());
		map.put("Mobile",zarrinTokenReq.getMobile());
		map.put("Description", zarrinTokenReq.getDescription());
		
		 HttpEntity<Map<String, Object>> request = new HttpEntity<>(map, headers);

	    String personResultAsJsonStr = 
			      restTemplate.postForObject("https://www.zarinpal.com/pg/rest/WebGate/PaymentRequest.json", request, String.class);
		
		return personResultAsJsonStr;
	    
	}
	
	@Override 
	public String zarrinVerify(ZarrinVerifyReq zarrinVerifyReq) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		
	    Map<String, Object> map = new HashMap<>();
		map.put("MerchantID", zarrinVerifyReq.getMerchantID());
		map.put("Authority", zarrinVerifyReq.getAuthority());
		map.put("Amount",zarrinVerifyReq.getAmount());
		
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(map, headers);

		String personResultAsJsonStr = 
			      restTemplate.postForObject("https://www.zarinpal.com/pg/rest/WebGate/PaymentVerification.json", request, String.class);
		
		return personResultAsJsonStr;


	}
}
