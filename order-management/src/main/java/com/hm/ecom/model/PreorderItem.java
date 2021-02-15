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
@Table(name = "ORM_PREORDERITEMS")
@XmlRootElement
public class PreorderItem {

											
	
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SRL")
    private Long srl;
    
    @JsonIgnore
    @Basic(optional = false)
    @Column(name = "OPOR_SRL")
    private Long preorder;
    
    @Basic(optional = false)
    @Column(name = "IGOD_SRL")
    private Long product;    

    @Basic(optional = true)
    @Column(name = "EXPIRE_DATE")
    private Date expireDate;
    
    @Basic(optional = true)
    @Column(name = "SSUP_SRL")
    private Long supplier;

    @Basic(optional = true)
    @Column(name = "QTY")
    private Long Qty;  

    @Basic(optional = true)
    @Column(name = "PRE_PRICE")
    private Long prePrice;  
    
    @Basic(optional = true)
    @Column(name = "POST_PRICE")
    private Long postPrice;  

    @Basic(optional = true)
    @Column(name = "GIFT_QTY")
    private Long giftQty; 
    
    @Basic(optional = true)
    @Column(name = "TAX")
    private Long tax; 
    
    @Basic(optional = true)
    @Column(name = "TOLL")
    private Long toll;
    
    @Basic(optional = true)
    @Column(name = "DISCOUNT")
    private Long disscount;     
}
