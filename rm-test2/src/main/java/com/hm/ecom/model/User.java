package com.hm.ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity

@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
@Table(name = "ORG_USERS")
@XmlRootElement
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public Long getSrl() {
		return srl;
	}

	public void setSrl(Long srl) {
		this.srl = srl;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
    @Basic(optional = false)
    @Column(name = "SRL")
    private Long srl;
    
    @Basic(optional = false)
    @Column(name = "ODOM_SRL")
    private Long companyId;
    
/*    @Basic(optional = false)
    @Column(name = "role_id")
    private int roleId;
    */
    @Basic(optional = false)
    @Column(name = "USER_NAME")
    private String userId;    
    
    @Basic(optional = false)
    @Column(name = "EMAIL_ADDRESS")
    private String email;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String passwordHash;
    
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    /*@Column(name = "middle_name")
    private String middleName;
    */
    @Column(name = "LAST_NAME")
    private String lastName;
    
   /* @Basic(optional = false)
    @Column(name = "USER_STATUS")
    private int status;*/
    
 /*   @JsonIgnore
    @Basic(optional = false)
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    @JsonIgnore
    @Basic(optional = false)
    @Column(name = "salt")
    private String salt;*/
    
}
