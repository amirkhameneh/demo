package com.hm.ecom.model;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@DynamicInsert
@DynamicUpdate
@Table(name = "TBL_REQUESTS")

public class RequestModel {


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Long getRequestRowCount() {
		return requestRowCount;
	}

	public void setRequestRowCount(Long requestRowCount) {
		this.requestRowCount = requestRowCount;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}

	public Long getTimePerCount() {
		return timePerCount;
	}

	public void setTimePerCount(Long timePerCount) {
		this.timePerCount = timePerCount;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getReponseBody() {
		return reponseBody;
	}

	public void setReponseBody(String reponseBody) {
		this.reponseBody = reponseBody;
	}

	@Id
    @Basic(optional = false)
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "request_date")
    private String requestDate;
    
    @Basic(optional = false)
    @Column(name = "user")
    private String user;  

    @Basic(optional = false)
    @Column(name = "request_status")
    private String requestStatus ;

    @Basic(optional = false)
    @Column(name = "request_row_count")
    private Long requestRowCount ;

    @Basic(optional = false)
    @Column(name = "execution_time")
    private Long executionTime ;
    
    @Basic(optional = false)
    @Column(name = "time_per_count")
    private Long timePerCount ;    
    
    @JsonIgnore
    @Basic(optional = false)
    @Column(name = "request_body")
    @Lob 
    private String requestBody ;  

    @JsonIgnore
    @Basic(optional = false)
    @Column(name = "response_body")
    @Lob 
    private String reponseBody ;    
}
