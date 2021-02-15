package com.hm.ecom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hm.ecom.model.ZarrinTokenReq;
import com.hm.ecom.model.ZarrinVerifyReq;
import com.hm.ecom.service.PaymentService;

@RestController
@RequestMapping(APIName.PAY)
public class PaymentController {
	
    @Autowired
    protected ResponseUtil responseUtil;
	
	@Autowired
	PaymentService paymentService;
	
    @RequestMapping(path = APIName.ZARRIN_TOKEN, method = RequestMethod.POST)
    public ResponseEntity<APIResponse> getZarrinToken(
            @PathVariable("company_id") Long company,
            @RequestBody ZarrinTokenReq zarrinTokenReq
             ) throws Exception {
		
		return responseUtil.successResponse(paymentService.zarrinGetAuthority(zarrinTokenReq));
    } 
    
    @RequestMapping(path = APIName.ZARRIN_VERIFY, method = RequestMethod.POST)
    public ResponseEntity<APIResponse> getZarrinToken(
            @PathVariable("company_id") Long company,
            @RequestBody ZarrinVerifyReq zarrinVerifyReq
             ) throws Exception {
		
		return responseUtil.successResponse(paymentService.zarrinVerify(zarrinVerifyReq));
    }       
}
