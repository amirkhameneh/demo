package com.hm.ecom.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
@Table(name = "COR_TOKENS")
@XmlRootElement
public class UserToken implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "TOKEN")
    private String token;
    
    @Basic(optional = false)
    @Column(name = "ODOM_SRL")
    private Long companyId;
    
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private String userId;
    
    @Basic(optional = false)
    @Column(name = "LOGIN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginDate;
    
    @Basic(optional = false)
    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    
    @Basic(optional = false)
    @Column(name = "SESSION_DATA")
    private String sessionData;
    
}
