package com.decepticons.assetManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.repositories.IDepartmentRepository;
import com.decepticons.assetManagement.repositories.IEmployeeRepository;
import com.decepticons.assetManagement.services.protocols.IDepartmentService;

@Service
public class DepartmentService implements IDepartmentService{

	@Autowired
	private IDepartmentRepository deptRepo;
	private IEmployeeRepository empRepo;
	
	public DepartmentService() {
	}
	
	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return deptRepo.findAll();
	}
	
	public Optional<Employee> findManagerById(int id) {
		Optional<Employee> optionalEmployee = empRepo.findById(id);
		return optionalEmployee;
	}
	
//	public Optional<Employee> findManagerById(int id) {
//		return empRepo.findById(id);
//	}

}
