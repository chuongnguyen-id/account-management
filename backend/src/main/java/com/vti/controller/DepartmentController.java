package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Department;
import com.vti.entity.form.DepartmentForm;
import com.vti.service.DepartmentService;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {

//	http://localhost:8080/api/v1/departments
		
	@Autowired
	private IDepartmentService service;

	public DepartmentController() {
		service = new DepartmentService();
	}

	@GetMapping
	public List<Department> getAll(@RequestParam(value = "name", required = false) String dpName){
		System.out.println("-->name = " + dpName);
		return service.getAllDepartments(dpName);
	}
	
//	@GetMapping
//	public List<Department> getAll(DepartmentSearchFillter fillter){
//		return service.getAllDepartments(fillter);
//	}
	
	@GetMapping(value = "/{idDepartment}")
	public Department getById(@PathVariable(value = "idDepartment") int id){
		return service.getDepartmentByID(id);
	}
	
	@DeleteMapping(value = "/{idDepartment}")
	public void deleteDepartment(@PathVariable(value = "idDepartment") int id){
		service.deleteDepartmentByID(id);
	}
	
	@PutMapping(value = "/{idDepartment}")
	public String updateDepartment(@PathVariable(value = "idDepartment") int id, @RequestBody DepartmentForm form){
		System.out.println("Data Update => " + form.toString());
		try {
			service.updateDepartment(id, form);
			return "Update Completed!";
		} catch (Exception e) {
			return "Update Failed: " + e.getMessage();
		}
	}
	
	@PostMapping()
	public String createDepartment(@RequestBody DepartmentForm form){
		System.out.println("Data Create => " + form.toString());
		try {
			service.createDepartment(form);
			return "Create Completed!";
		} catch (Exception e) {
			return "Create Failed: " + e.getMessage();
		}
		
	}
}
