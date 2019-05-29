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
	public List<Department> findByDeptName(String name) {
		List<Department> dept = deptRepo.findByDeptName(name);
		return dept;
	}
	
	
	@Override
	public void saveDepartment(Department dept) {
		System.out.println("---------------------------");
		System.out.println(dept.getDeptId());
		System.out.println(dept.getDeptName());
		deptRepo.save(dept);
	}
	
	@Override
	public void updateDepartment(Department dept) {
		System.out.println("--------------------------- in service update");
		System.out.println(dept.getDeptId());
		System.out.println(dept.getDeptName());
		deptRepo.save(dept);
	}

	@Override
	public void deleteDepartment(Department dept) {
		System.out.println("--------------------------- in service delete");
		System.out.println(dept.getDeptId());
		System.out.println(dept.getDeptName());
		deptRepo.delete(dept);
	}
}
