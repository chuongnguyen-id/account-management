package com.vti;

import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.GroupAccount;
import com.vti.entity.Position;
import com.vti.repository.AccountRepository;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.GroupAccountRepository;
import com.vti.repository.PositionReponsitory;

public class MainTest {

	public static void main(String[] args) {

//		getAccountByID(1);
//		updateAccountByID(1, "nva", "Nguyen Van A", "nva@gmail.com");
//		deleteAccountByID(1);
//		createAccount("nvb", "Nguyen Van B", "nvb@gmail.com");
//		getAllAccounts();
		
//		getAllPositions();
		
//		getAllGroupAccount();
		
//		getAllDepartments();
		
//		createDepartment("Sale");
	}

//	public static void getAllAccounts() {
//		AccountRepository repository = new AccountRepository();
//
//		List<Account> list = repository.getAllAccounts();
//
//		for (Account account : list) {
//			System.out.println(account.stringFormat());
//		}
//	}
	
	public static void getAccountByID(int id) {
		AccountRepository repository = new AccountRepository();

		Account account = repository.getAccountByID(id);

		System.out.println(account.stringFormat());
	}
	
//	public static void updateAccountByID(int id, String userNameNew, String fullNameNew, String emailNew) {
//		AccountRepository repository = new AccountRepository();
//
//		repository.updateAccountByID(id, userNameNew, fullNameNew, emailNew);
//
//	}
	
	public static void deleteAccountByID(int id) {
		AccountRepository repository = new AccountRepository();

		repository.deleteAccountByID(id);

	}
	
//	public static void createAccount(String userNameNew, String fullNameNew, String emailNew) {
//		AccountRepository repository = new AccountRepository();
//
//		repository.createAccount(userNameNew, fullNameNew, emailNew);
//
//	}
	
	public static void getAllPositions() {
		PositionReponsitory reponsitory = new PositionReponsitory();
		
		List<Position> list = reponsitory.getAllPositions();
		for (Position position : list) {
			System.out.println(position.toString());
		}
	}
	
	public static void getAllGroupAccount() {
		GroupAccountRepository reponsitory = new GroupAccountRepository();
		
		List<GroupAccount> list = reponsitory.getAllGroupAccount();
		for (GroupAccount groupAccount : list) {
			System.out.println(groupAccount.toString());
		}
	}
	
//	public static void getAllDepartments() {
//		DepartmentRepository repository = new DepartmentRepository();
//
//		List<Department> list = repository.getAllDepartments();
//
//		for (Department department : list) {
//			System.out.println(department.toString());
//		}
//	}
	
	public static void createDepartment(Department department) {
		DepartmentRepository repository = new DepartmentRepository();

		repository.createDepartment(department);

	}
}
