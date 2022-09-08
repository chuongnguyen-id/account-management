package com.vti.entity.fillter;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountSearchFillter {

	private int id;
	private String userName;
	private String email;
	private String fullName;
	private String departmentName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	private String search;
	
}
