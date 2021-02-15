package com.hm.ecom.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductAttribute implements Serializable {
	
	
    @Id
    @Basic(optional = false)
    @Column(name = "SRL")
    private Long srl;
    
    @Basic(optional = false)
    @Column(name = "ATTRIBUTE_NAME")
    private Long name;
	
}
