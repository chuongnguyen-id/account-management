package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.entity.form.DepartmentForm;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	@Override
	public List<Department> getAllDepartments(String dpName) {
		return repository.getAllDepartments(dpName);
	}

//	@Override
//	public List<Department> getAllDepartments(DepartmentSearchFillter fillter){
//		return repository.getAllDepartments(fillter);
//	}

	@Override
	public Department getDepartmentByID(int id) {
		return repository.getDepartmentByID(id);
	}

	@Override
	public Department deleteDepartmentByID(int id) {
		return repository.deleteDepartmentByID(id);
	}

	@Override
	public void updateDepartment(int id, DepartmentForm form) throws Exception {
		// Step 1: Search Department by ID
		Department dp = repository.getDepartmentByID(id);
		if (dp == null) {
			throw new Exception("Not Found Department!");
		}

		// Step 2: update new data into new Department
		if (form.getName() != null) {
			dp.setName(form.getName());
		}
		repository.updateDepartment(dp);

		return;
	}

	@Override
	public void createDepartment(DepartmentForm form) throws Exception {
		// Step 1: Search Department by Name
		Department dp = repository.getDepartmentByName(form.getName());
		if (dp != null) {
			throw new Exception("Exist DepartmentName!");
		}

		// Step 2: create new data into new Department
		Department department = new Department();
		department.setName(form.getName());

		repository.createDepartment(department);
	}
}
