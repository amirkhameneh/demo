package com.hm.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hm.ecom.model.RequestDetail;
import com.hm.ecom.model.RequestModel;
import com.hm.ecom.repository.RequestRepository;


@Component
public class MonitoringServiceImpl implements MonitoringService{

    @Autowired
    protected RequestRepository requestRepository;
    
	public Iterable<RequestModel> getRequests(){
		return requestRepository.findAll();
	}
	public RequestDetail getRequestDetail(Long id) {
		
		RequestModel requestModel = new RequestModel();
		requestModel = requestRepository.findById(id).get();
		
		
		RequestDetail requestDetail = new RequestDetail();		
		requestDetail.setInputBody(requestModel.getRequestBody());
		requestDetail.setOutputBody(requestModel.getReponseBody());
		
		return requestDetail;
		
		
	}
}
