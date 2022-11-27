package com.vti.repository;

import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentRepository {

	public List<Department> getAllDepartments(String dpName);
	
//	public List<Department> getAllDepartments(DepartmentSearchFillter fillter);
	
	public Department getDepartmentByID(int id);

	public Department deleteDepartmentByID(int id);

//	public void updateDepartment(int id, DepartmentForm form);

	public void updateDepartment(Department dp);

	public void createDepartment(Department dp);

	public Department getDepartmentByName(String name);

}
