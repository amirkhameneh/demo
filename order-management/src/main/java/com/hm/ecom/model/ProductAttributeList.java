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
@Table(name = "PCM_ATTRIBUTELISTS")
@XmlRootElement
public class ProductAttributeList {
    @Id
    @Basic(optional = false)
    @Column(name = "SRL")
    private Long srl;
    
    @Basic(optional = false)
    @Column(name = "PATT_SRL")
    private Long attribute;
    
    @Basic(optional = false)
    @Column(name = "ENTITY_CODE")
    private String code;

    @Basic(optional = false)
    @Column(name = "ENTITY_DESC")
    private String name;

    @Basic(optional = false)
    @Column(name = "ORDER_NO")
    private Long order;  
}
