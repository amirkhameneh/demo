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
@Table(name = "PCM_IMAGES_VW")
@XmlRootElement
public class ProductImage {


	    @Id
	    @Basic(optional = false)
	    @JsonIgnore
	    @Column(name = "ID")
	    private Long id; 
    
	    @Basic(optional = false)
	    @Column(name = "SRL")
	    @JsonIgnore
	    private Long srl;
	    
	    @Basic(optional = false)
	    @Column(name = "IMAGE")
	    private String image;

	
}

