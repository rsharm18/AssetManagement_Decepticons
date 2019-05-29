package com.decepticons.assetManagement.services.protocols;

import java.util.List;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.Employee;


public interface IEmployeeService {

	public List<Employee> findAll();

	public Employee findById(int Id);
	public void save (Employee employee);
	public void deleteById(int id);
	public void updateEmployee(Employee emp);
	public List<Employee> findByDepartment(Department dept);


	public void removeFromDepartment(Employee emp);

	public List<Employee> findByNullDepartment();

	public void addToDepartment(Employee emp, Department dept);

	public int countByDepartment(Department dept);

	
	public Employee findByUserName(String userName);

}
