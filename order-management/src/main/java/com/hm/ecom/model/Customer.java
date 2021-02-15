package com.hm.ecom.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
@Table(name = "CRM_CUSTOMERS")
@XmlRootElement
public class Customer {
	
    @Id
    @Basic(optional = false)
    @Column(name = "SRL")
    private Long srl;
    
    @JsonIgnore
    @Basic(optional = false)
    @Column(name = "ODOM_SRL")
    private Long domain;
    
    
    @Basic(optional = false)
    @Column(name = "CUSTOMER_TYPE")
    private String customerType;
    
    @Basic(optional = false)
    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    
    @Basic(optional = false)
    @Column(name = "NATIONAL_ID")
    private String nationalId;
    
    @Basic(optional = false)
    @Column(name = "OUSR_SRL")
    private Long userSrl;    
}
