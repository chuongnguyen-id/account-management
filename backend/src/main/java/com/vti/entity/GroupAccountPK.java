package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GroupAccountPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "GroupID")
	private int groupID;
	
	@Column(name = "AccountID")
	private int accountID;
	
}
