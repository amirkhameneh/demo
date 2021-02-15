package com.hm.ecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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
@Table(name = "ORM_PREORDERITEMS_VW")
@XmlRootElement
public class PreorderItemView {
	@Id
    @Column(name = "SRL")
    Long srl;
	
    @Column(name = "PREORDER_ID")
    @JsonIgnore
    String preorder;	
    
    @Column(name = "GOOD_NAME")
    String product;

    @Column(name = "IMAGE")
    String image;
    
    @Column(name = "SUPPLIER_NAME")
    String supplier;
    
    @Column(name = "QTY")
    Long qty;

    @Column(name = "PRE_PRICE")
    Long prePrice;
    
    @Column(name = "POST_PRICE")
    Long postPrice;
}


	
