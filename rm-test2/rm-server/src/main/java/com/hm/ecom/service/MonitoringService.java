package com.hm.ecom.service;

import java.util.List;

import com.hm.ecom.model.AggregationRequest;
import com.hm.ecom.model.RequestDetail;
import com.hm.ecom.model.RequestModel;

public interface MonitoringService {
	public Iterable<RequestModel> getRequests();
	public RequestDetail getRequestDetail(Long id);
	
}
