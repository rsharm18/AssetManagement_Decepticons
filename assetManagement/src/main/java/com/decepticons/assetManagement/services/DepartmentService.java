package com.decepticons.assetManagement.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

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
	
	@Override
	public Department findById(int id) {
		Optional<Department> dept = deptRepo.findById(id);
		if(dept.isPresent()) {
			return dept.get();
		}
		else {
			throw new RuntimeException("Department not found with ID = " + id);
		}
	}
	
	@Override
	public List<Department> findByDeptNameIgnoreCaseContaining(String name) {
		List<Department> dept = deptRepo.findByDeptNameIgnoreCaseContaining(name);
		return dept;
	}
	
	
	@Override
	public void saveDepartment(Department dept) {
		deptRepo.save(dept);
	}
	
	@Override
	public void updateDepartment(Department dept) {
		deptRepo.save(dept);
	}

	
	@Override
	public Department findByDeptName(String name) {
		//List<Department> dept = deptRepo.findByDeptName(name);
		Department dept = deptRepo.findByDeptName(name);
		
		return dept;
	}
		@Override
	public List<Department> findByDeptNameIgnoreCaseContaining(String name) {
		List<Department> dept = deptRepo.findByDeptNameIgnoreCaseContaining(name);
		return dept;
	}
	
	
	@Override
	public void saveDepartment(Department dept) {
		deptRepo.save(dept);
	}
	
	@Override
	public void updateDepartment(Department dept) {
		deptRepo.save(dept);
	}

	@Override
	public void deleteDepartment(Department dept) {
		deptRepo.delete(dept);
	}
	
	@Override
	public Department findResourcePool() {
		Department dept = deptRepo.findByDeptName("Resource Pool");
		return dept;		
	}
}
