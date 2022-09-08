package com.vti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class Account {
	
	@Column(name = "AccountID")
	@Id	// primary key	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// auto increment
	private int id;
	
	@Email(message = "Email không hợp lệ!")
	@Column(name = "Email", length = 100, unique = true)
	private String email;
	
	@NotBlank(message = "{Account.createAccount.form.userName.NotBlank}")
	@Column(name = "UserName")
	private String userName;
	
	@NotBlank(message = "{Account.createAccount.form.userName.NotBlank}")
	@Column(name = "FullName")
	private String fullName;
	
	@Column(name = "Role")
	private String role;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DepartmentID")
	private Department department;
	
	public String stringFormat() {
		return String.format("%5d | %30s | %25s | %25s | %25s", id, email, userName, fullName, createDate);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName
				+ ", createDate=" + createDate + ", department=" + department + "]";
	}

	
}
