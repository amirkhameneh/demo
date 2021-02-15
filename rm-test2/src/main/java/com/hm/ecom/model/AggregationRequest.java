package com.hm.ecom.model;

import java.util.List;

public class AggregationRequest {
	public List<Value> getHeaders() {
		return headers;
	}
	public void setHeaders(List<Value> headers) {
		this.headers = headers;
	}
	public List<Row> getRows() {
		return rows;
	}
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	List<Value> headers;
	List<Row> rows;
}
