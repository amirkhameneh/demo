package com.hm.ecom.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hm.ecom.model.AggregationRequest;
import com.hm.ecom.repository.RequestRepository;
import com.hm.ecom.service.AggregationService;


@RestController
@RequestMapping(APIName.AGGREGATION)
public class AggregationController {
	
    @Autowired
    protected ResponseUtil responseUtil;

    @Autowired
    protected AggregationService aggregationService;
    
    
    @RequestMapping(path = APIName.MEDIAN, method = RequestMethod.POST)
    public ResponseEntity<APIResponse> getMedian(
            /*@PathVariable("company_id") Long company,*/
            @RequestBody AggregationRequest aggregationRequest
             ) throws Exception {
		
		return responseUtil.successResponse(aggregationService.getMedian(aggregationRequest));
    } 
    
    @RequestMapping(path = "getrequests", method = RequestMethod.POST)
    public ResponseEntity<APIResponse> getRequests(
            /*@PathVariable("company_id") Long company,*/
           // @RequestBody AggregationRequest aggregationRequest
             ) throws Exception {
		
		return responseUtil.successResponse("sss");
    } 
}
