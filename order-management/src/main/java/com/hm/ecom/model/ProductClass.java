package com.hm.ecom.model;

import javax.persistence.Basic;
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
@Table(name = "PCM_PRODUCTCLASS_VW")
@XmlRootElement
public class ProductClass {




		    @Id
		    @Basic(optional = false)
		    @Column(name = "SRL")
		    private Long srl; 
	    
		    @Basic(optional = false)
		    @Column(name = "PARENT_SRL")
		    @JsonIgnore
		    private Long parent;

		    @Basic(optional = false)
		    @Column(name = "GOOD_NAME")
		    private String name;

		    @Basic(optional = false)
		    @Column(name = "PROP_CT")
		    private String color;
		    
		    @Basic(optional = false)
		    @Column(name = "PROP_CC")
		    private String colorCode;
		    
		    @Basic(optional = false)
		    @Column(name = "PROP_ST")
		    private String size;

}
