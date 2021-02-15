package com.hm.ecom.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hm.ecom.model.AggregationRequest;
import com.hm.ecom.model.RequestModel;
import com.hm.ecom.model.Row;
import com.hm.ecom.model.Value;
import com.hm.ecom.repository.RequestRepository;


@Component
public class AggregationServiceImpl implements AggregationService {
	
	@Autowired
	RequestRepository requestRepository;
	
	
	public AggregationRequest getMedian(AggregationRequest aggregationRequest) {		 

		 //Find the index of "label" Column
		 int labelColIndex = 0;
		 int colCount = 0;
		 int i=0;
		 for(Value val : aggregationRequest.getHeaders()) {
			 		//System.out.print(val.getV().toLowerCase());
			   if (val.getV().toLowerCase().equals("label")) {
				   
				   labelColIndex = i;
			   }
			   i++;
		  }
		 
		 colCount = i ;
		 
		 
		 String inputBody="";
		 int rowCount=0;
		 HashMap<String,HashMap<Integer,ArrayList<String>>> dataSet=
				 new HashMap<String,HashMap<Integer,ArrayList<String>>> ();
		 
		 for(Row row : aggregationRequest.getRows()) {
			 HashMap<Integer,ArrayList<String>> rowDet= new HashMap<Integer,ArrayList<String>>();
			 
			 
			 if (dataSet.get(row.getRow().get(labelColIndex).getV())!= null) {
				 rowDet = dataSet.get(row.getRow().get(labelColIndex).getV());
			 }
			 
			 for (int c=0;c<colCount;c++) {
				 ArrayList<String> arr=new ArrayList();
				 
				 if (rowDet.get(c) == null ) {
					 arr.add(row.getRow().get(c).getV());
					 inputBody = inputBody + row.getRow().get(c).getV()+";";
				 }else {
				    arr = rowDet.get(c);
				 	arr.add(row.getRow().get(c).getV());
				 	inputBody = inputBody + row.getRow().get(c).getV()+";";
				 }
				 rowDet.put(c,arr);
						
			 }
			 
			 inputBody = inputBody + "\n";
			 rowCount++;
			 
			 dataSet.put(row.getRow().get(labelColIndex).getV(),rowDet);   
		
		  }		 
		 
		 //System.out.print(inputBody);

		 
		 String outputBody="";
		 
		 AggregationRequest response= new AggregationRequest();
		 
		 response.setHeaders(aggregationRequest.getHeaders());
		 
		 List<Row> responseRows = new ArrayList();
		 
		 for(Map.Entry cluster:dataSet.entrySet())  
	     {  
			 List<Value> rowVals = new ArrayList();
			 for (int c=0;c<colCount;c++) {
				 Value  val = new Value(); 
				 String median;
				 ///Find the median
				 //ArrayList<Float> longSet = new ArrayList<Float>();
				 double[] longSet = new double[dataSet.get(cluster.getKey()).get(c).size()];
				 int isNumerical=1;
				 int z=0;
				 for(String stringValue : dataSet.get(cluster.getKey()).get(c)) {
			            try {
			            	
			                //Convert String to Integer, and store it into integer array list.
			            	//longSet.add(Float.parseFloat(stringValue));
			            	longSet[z]=Double.parseDouble(stringValue);
			            } catch(NumberFormatException nfe) {
			               //System.out.println("Could not parse " + nfe);
			            	isNumerical=0;  
			            	break;
			            } 
			            z++;
			     } 
				 if (isNumerical==1 && c !=labelColIndex) {
					 Arrays.sort(longSet);
					 if (longSet.length == 1 ) {
						 median =String.valueOf((double) longSet[0]);
					 }else if (longSet.length % 2 == 0)
					     median = String.valueOf(((double)longSet[longSet.length/2] + (double)longSet[longSet.length/2 - 1])/2);
					 else
					     median = String.valueOf((double) longSet[longSet.length/2]);
				 }else {
					 median = dataSet.get(cluster.getKey()).get(c).get(0);
				 }

				 
				 val.setV(median);
				 rowVals.add(val);
				 outputBody = outputBody + median+ ';';
			 }
			 Row responseRow = new Row();
			 responseRow.setRow(rowVals);
	        //System.out.println(m.getKey()+" "+m.getValue());
			 responseRows.add(responseRow);
			 outputBody = outputBody  + "\n";
	     }  
		 
		response.setRows(responseRows);
		//System.out.print(rowCount);
		
		//save
		RequestModel requestmodel = new RequestModel();
		
		requestmodel.setRequestDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		requestmodel.setRequestStatus("Success");
		requestmodel.setUser("Heptamatrix Co");
		requestmodel.setRequestRowCount(Long.valueOf( rowCount));
		requestmodel.setExecutionTime(Long.valueOf( 1200));
		requestmodel.setTimePerCount( Long.valueOf(Math.round(1200 /rowCount +1)) );
		requestmodel.setRequestBody(inputBody);
		requestmodel.setReponseBody(outputBody);
		
		requestRepository.save(requestmodel);
		
		return response;
				//aggregationRequest.getRows().get(0).getRow().get(0).getV();
	}
}
