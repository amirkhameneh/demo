package com.hm.ecom.model;

import java.io.Serializable;

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
@Table(name = "PCM_PRODUCTFILTERS")
@XmlRootElement
public class ProductFilter implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "SRL")
    private Long srl;
    
    @Basic(optional = false)
    @Column(name = "IGOD_SRL")
    private Long product;
    
    @Basic(optional = false)
    @Column(name = "ODOM_SRL")
    private Long domain;
    
    @Basic(optional = false)
    @Column(name = "PFLT_SRL")
    private Long filter;

    @Basic(optional = false)
    @Column(name = "P_VAL")
    private Long value;

    @Basic(optional = false)
    @Column(name = "FILTER_TYPE")
    private Long type;
    
    @Basic(optional = false)
    @Column(name = "P_TEXT")
    private String text;    
    				
}
