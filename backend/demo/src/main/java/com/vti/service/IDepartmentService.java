package com.vti.service;

import java.util.List;

import com.vti.entity.form.DepartmentForm;
import com.vti.entity.Department;

public interface IDepartmentService {

	public List<Department> getAllDepartments(String dpName);
	
//	public List<Department> getAllDepartments(DepartmentSearchFillter fillter);
	
	public Department getDepartmentByID(int id);

	public Department deleteDepartmentByID(int id);

	public void updateDepartment(int id, DepartmentForm form) throws Exception;

	public void createDepartment(DepartmentForm form) throws Exception;

}
