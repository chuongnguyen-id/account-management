package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "GroupAccount")
public class GroupAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GroupAccountPK id;
	
	@Column(name = "JoinDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joinDate;

	@Override
	public String toString() {
		return "GroupAccount [id=" + id + ", joinDate=" + joinDate + "]";
	}
	
	
	
}
