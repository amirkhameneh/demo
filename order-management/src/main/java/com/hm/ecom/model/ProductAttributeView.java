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
@Table(name = "INV_GOOD_ATTRIBUTE_VW")
@XmlRootElement
public class ProductAttributeView {
	
	@Id
	@JsonIgnore
    @Column(name = "SRL")
    Long srl;
	
    @Column(name = "IGOD_SRL")
    @JsonIgnore
    Long product;
    
    @Column(name = "ATTRIBUTE_NAME")
    String attributeName;
    
    @Column(name = "ORDER_NO")
    Long order;
    
    @Column(name = "VALUE")
    String value;
    
  
}
