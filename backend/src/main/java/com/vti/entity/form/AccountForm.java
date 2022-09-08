package com.vti.entity.form;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountForm {

	private String email;
	private String userName;
	private String fullName;
	private String departmentName;
	private Date createDate;
	
}
