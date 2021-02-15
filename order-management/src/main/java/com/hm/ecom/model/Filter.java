package com.hm.ecom.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "PCM_FILTERS")
@XmlRootElement

public class Filter implements Serializable{
    @Id
    @Basic(optional = false)
    @Column(name = "SRL")
    private Long srl;
    
    @JsonIgnore
    @Basic(optional = false)
    @Column(name = "ODOM_SRL")
    private Long companyId;
    
    
    @Basic(optional = false)
    @Column(name = "FILTER_CODE")
    private String code;    
    
    
    @Basic(optional = false)
    @Column(name = "FILTER_NAME")
    private String name;

    
    @Basic(optional = false)
    @Column(name = "FILTER_TYPE")
    private String type;

    @JsonIgnore
    @Basic(optional = true)
    @Column(name = "SOURCE_TYPE")
    private String sourceType;
    
    @JsonIgnore
    @Basic(optional = true)
    @Column(name = "FILTER_SOURCE")
    private String source;
    
    @JsonIgnore
    @Basic(optional = true)
    @Column(name = "WHERE_CLAUSE")
    private String whereClause;

    @JsonIgnore
    @Basic(optional = true)
    @Column(name = "PATT_SRL")
    private Long atrribute;
    
    @JsonIgnore
    @Basic(optional = true)
    @Column(name = "PCAT_SRL")
    private Long category;
    
    @JsonIgnore
    @Basic(optional = true)
    @Column(name = "OCNR_SRL")
    private Long center;  
    
    @Basic(optional = true)
    @Column(name = "ORDER_NO")
    private Long order;   

    @JsonIgnore
    @Basic(optional = true)
    @Column(name = "CLNG_SRL")
    private Long language; 
    
    @Transient
    @JsonProperty
    public String isMale() {
        return "amir";
    }
    
    
}
