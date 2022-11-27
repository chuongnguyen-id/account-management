package com.vti.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

	public AccountDTO(int id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}

	@NonNull
	private int id;
	
	@NonNull
	private String userName;
	
	@NonNull
	private String email;
	
	@NonNull
	private String fullName;
	
	private String departmentName;
	
	private Date createDate;
	
	private String password;
}
