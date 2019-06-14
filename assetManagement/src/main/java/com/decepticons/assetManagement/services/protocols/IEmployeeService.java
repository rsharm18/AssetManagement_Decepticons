package com.decepticons.assetManagement.services.protocols;

import java.util.List;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.Role;

public interface IEmployeeService {

	public List<Employee> findAll();

	public Employee findById(int Id);

	public Employee save(Employee employee);

	public void deleteById(int id);

	public String updateEmployee(Employee emp);

	public List<Employee> findByDepartment(Department dept);

	public void removeFromDepartment(Employee emp, Department resourcePool);

	public List<Employee> findByNullDepartment();

	public void addToDepartment(Employee emp, Department dept);

	public int countByDepartment(Department dept);

	public Employee findByFirstnameAndLastname(String firstname, String lastname);

	public List<Employee> findByManager(Employee manager);

	public Employee findByUserName(String userName);

	public List<Employee> searchResourcePool(String name, Department dept);

	public List<Employee> findByRole(Role r);

	public void removeFromRole(Employee emp);

	public int countByRole(Role role);

	public List<Employee> findByFirstnameOrLastnameOrRoleOrDepartmentOrUserNameAllIgnoreCase(String firstname, String lastname, Role role, Department department, String userName);

}
