package com.vti.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.vti.entity.Department;

@Repository
@Primary
public interface DepartmentRepositoryV2 extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {

	Department findByName(String Name);
}
