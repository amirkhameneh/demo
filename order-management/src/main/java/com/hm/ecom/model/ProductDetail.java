package com.hm.ecom.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@Table(name = "INV_GOODS_VW")
@XmlRootElement
public class ProductDetail implements Serializable{
    @Id
    @Basic(optional = false)
    @Column(name = "SRL")
	Long srl;
    
    @Basic(optional = false)
    @Column(name = "GOOD_NAME")
	String name;
    
    @Basic(optional = false)
    @Column(name = "PARENT_SRL")
    Long parent;
    
    @Basic(optional = false)
    @Column(name = "LATIN_NAME")
	String lname;

    @Basic(optional = false)
    @Column(name = "BRAND_NAME")
	String brand;
    
    @Basic(optional = false)
    @Column(name = "PRICE")
	String title;

    @Basic(optional = false)
    @Column(name = "IMAGE")
	String image;
    
    @Lob
    @Column(name = "CONTENT")
	String description;

    @Basic(optional = false)
    @Column(name = "PRE_PRICE")
    Long prePrice;
    
    @Basic(optional = false)
    @Column(name = "POST_PRICE")
    Long postPrice;    
    
    @Basic(optional = false)
    @Column(name = "QTY")
    Long qty;      
}
