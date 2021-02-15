package com.hm.ecom.api;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	import com.hm.ecom.model.AggregationRequest;
	import com.hm.ecom.model.RequestModel;
	import com.hm.ecom.repository.RequestRepository;
	import com.hm.ecom.service.AggregationService;
	import com.hm.ecom.service.MonitoringService;


	@RestController
	@RequestMapping(APIName.MONITORING)
	public class MonitoringController {

	    @Autowired
	    protected ResponseUtil responseUtil;
	    
	    @Autowired
	    protected MonitoringService monitoringService;	    
	    
	    @RequestMapping(path = APIName.REQUESTS, method = RequestMethod.POST)
	    public ResponseEntity<APIResponse> getRequests(
	            /*@PathVariable("company_id") Long company,*/
	            @RequestBody AggregationRequest aggregationRequest
	             ) throws Exception {
			
			return responseUtil.successResponse(monitoringService.getRequests());
	    } 
	    
	    @RequestMapping(path = APIName.REQUEST_DETAIL, method = RequestMethod.POST)
	    public ResponseEntity<APIResponse> getRequests(
	            /*@PathVariable("company_id") Long company,*/
	              @RequestBody RequestModel requestModel
	             ) throws Exception {
			
			return responseUtil.successResponse(monitoringService.getRequestDetail(requestModel.getId()));
	    } 
	}

