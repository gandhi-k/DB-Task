package org.ifc.restservices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author kumar 
 *
 * 
 * this is Customer model 
 * 
 * 
 */



@Entity
@Table(name = "Customers")
@EntityListeners(AuditingEntityListener.class)

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Cus_Id")
	private long id;

	@NotEmpty
	@Column(name = "Cus_Name")
	private String name;
    
	@NotEmpty
	@Column(name = "Cus_Location")
	private String location;
    
	//@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "Cus_Date")
	private Date cusdate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCusdate() {
		return cusdate;
	}

	public void setCusdate(Date cusdate) {
		this.cusdate = cusdate;
	}

}
