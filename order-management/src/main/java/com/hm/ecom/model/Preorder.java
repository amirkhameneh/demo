package com.hm.ecom.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "ORM_PREORDERS")
@XmlRootElement
public class Preorder {
		
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SRL")
    private Long srl;
    
    @JsonIgnore
    @Basic(optional = false)
    @Column(name = "ODOM_SRL")
    private Long domain;
    
    
    @Basic(optional = false)
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PREORDER_DATE")
    private Date orderDate;   	
    
    @Basic(optional = false)
    @Column(name = "PREORDER_ST")
    private Long orderSt;    
    
    @Basic(optional = false)
    @Column(name = "PREORDER_TYPE")
    private String orderType; 
    
    @Basic(optional = true)
    @Column(name = "ID")
    private String id; 
    
    
    @Basic(optional = false)
    @Column(name = "CCST_SRL")
    private Long customer;
    
    @Basic(optional = false)
    @Column(name = "OCNR_SRL")
    private Long center;    
    
    @Basic(optional = false)
    @Column(name = "TOKEN")
    private String token;  
    
    @Basic(optional = true)
    @Column(name = "OTMW_SRL")
    private Long timeWindow;

    @Basic(optional = true)
    @Column(name = "CCNT_SRL")
    private Long contact;
    
    @Basic(optional = true)
    @Column(name = "MRCI_SRLS")
    private Long marketingSrls; 

    @Basic(optional = true)
    @Column(name = "MRCI_AMT")
    private Long marketingAmt;
    
    @Basic(optional = true)
    @Column(name = "SHIPMENT_AMT")
    private Long shipmentAmt;
    
    @Basic(optional = true)
    @Column(name = "PAYMENT_TYPE")
    private Long paymentType; 
    
    @Basic(optional = true)
    @Column(name = "PAYMENT_AMT")
    private Long paymentAmt; 
    
    @Basic(optional = true)
    @Column(name = "REF_NO")
    private String refNo; 
    
    @Basic(optional = true)
    @Column(name = "MRCI_CODES")
    private String marketingCode; 
    
    @Basic(optional = true)
    @Column(name = "FINAL_AMOUNT")
    private Long finalAmt;

    @Basic(optional = true)
    @Column(name = "MFLT_SRL")
    private Long affiliate;
    
    @Basic(optional = true)
    @Column(name = "MFLT_CODE")
    private String affiliateCode;
    
    
    
}
