package com.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.entity.Department;
import com.ms.repository.DepartmentRepository;


@Service

public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	

	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
