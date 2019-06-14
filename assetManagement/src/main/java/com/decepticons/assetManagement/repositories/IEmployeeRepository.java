package com.decepticons.assetManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.Role;

@RepositoryRestResource
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findByDepartment(Department dept);

	public Employee findByUserName(String userName);

	public List<Employee> findByFirstnameIgnoreCaseContainingAndDepartment(String name, Department dept);
	public Employee findByFirstnameIgnoreCaseAndLastnameIgnoreCase(String firstname, String lastname);

	public List<Employee> findByFirstnameIgnoreCaseContainingAndDepartment(String name, Department dept);

	public List<Employee> findByManager(Employee manager);
	List<Employee> findByRole(Role r);
	public List<Employee> findByFirstnameOrLastnameOrRoleOrDepartmentOrUserNameAllIgnoreCase(@Param("name") String firstname, @Param("name") String lastname, @Param("role") Role role,
			@Param("department") Department department, @Param("userID") String userName);

}
