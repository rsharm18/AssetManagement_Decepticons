package com.decepticons.assetManagement.services;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.Role;
import com.decepticons.assetManagement.entity.UserAuth;
import com.decepticons.assetManagement.repositories.IEmployeeRepository;
import com.decepticons.assetManagement.repositories.IUserAuthRepository;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;
import com.decepticons.assetManagement.services.protocols.IUserAuthService;
import com.decepticons.assetManagement.util.AssetManagementUtil;

@Service
public class EmployeeService implements IEmployeeService {

	private static AssetManagementUtil util = AssetManagementUtil.getFormatter();

	private static Department dept = new Department();
	private static Role role = new Role();

	@Autowired
	private IEmployeeRepository empRepo;

	@Autowired
	private IUserAuthRepository userAuthRepo;

	@Autowired
	private IUserAuthService userAuthService;

	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee findById(int Id) {
		Optional<Employee> result = empRepo.findById(Id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Employee not found witn ID=" + Id);
		}
	}

	@Override
	public Employee save(Employee employee) {

		String userName;
		if (util.isNewUser(employee)) {

			//logic for new empid
			List<Employee> empList = empRepo.findAll();
			int iNextId = -1;
			if (empList.size() == 0) {
				iNextId = 10;
			} else {
				iNextId = empList.get(empList.size() - 1).getId();
			}
			userName = util.generateUserName(employee, iNextId + empList.size());
			System.out.println("username " + userName);
			employee.setUserName(userName);
//			employee.setPassword(userName);
			// employee.setDepartment(dept);
			// employee.setRole(role);
		}
		userName = employee.getUserName();

		UserAuth userAuth = userAuthRepo.findByUserNameEquals(userName);
		System.out.println("userName :: " + userName + " userAuth " + userAuth);
		if (userAuth == null) {
			userAuth = new UserAuth();
			userAuth.setUserName(userName);
			userAuth.setPassword(userName);

			userAuthService.save(userAuth);
		}

		return empRepo.save(employee);

	}

	@Override
	public void deleteById(int id) {

		Employee emp = findById(id);
		if (emp != null) {
			UserAuth userAuth = userAuthRepo.findByUserNameEquals(emp.getUserName());

			System.out.println(" userAuth " + userAuth);

			if (userAuth != null)
				userAuthService.delete(userAuth);

			empRepo.deleteById(id);
		}

	}

	/**
	 * updates only selcted fields
	 * 
	 * @return
	 */
	@Override
	public String updateEmployee(Employee emp) {

		System.out.println("from updateEmployee" + emp);
		Employee temp = null;
		String msg = "";
		if (util.isNewUser(emp)) {
			System.out.println("calling save " + emp);
			temp = save(emp);
			msg = "Successfully created the user with userName=" + temp.getUserName();
			return msg;
		}

		System.out.println("Continue Update");
		Employee employee = findById(emp.getId());

		// System.out.println("Employess before change "+employee);

		try {

			Method[] method = Class.forName(Employee.class.getName()).getMethods();
			for (Method m : method) {

				if (m.getName().startsWith("get") && !Employee.skipMethodsListFromPersist.contains(m.getName()))// !m.getName().equals("getId") && !m.getName().equals("getClass")) {
				{
					// m.setAccessible(true);
					Object data = m.invoke(emp, null);

					System.out.println(m.getName() + " Data " + data + " return type " + m.getReturnType());

					if (data != null) {
						String methodName = m.getName().replace("get", "set");

						Method setter = Class.forName(Employee.class.getName()).getMethod(methodName, m.getReturnType());
//						System.out.println("invoke "+setter.getName());
						setter.invoke(employee, data);
					}

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		temp = save(employee);
		msg = "Successfully updated the user with userName=" + temp.getUserName();

		return msg;
		// System.out.println("Employess after change "+employee);

	}

	@Override
	public List<Employee> findByDepartment(Department dept) {
		// TODO Auto-generated method stub
		return empRepo.findByDepartment(dept);
	}

	@Override
	public Employee findByUserName(String userName) {
		return empRepo.findByUserName(userName);
	}

//	@Override
//	public Integer countByDepartment(Department d) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Employee> findByNullDepartment() {
		// TODO Auto-generated method stub
		return empRepo.findByDepartment(null);
	}

	@Override
	public void addToDepartment(Employee emp, Department dept) {
		// TODO Auto-generated method stub
		emp.setDepartment(dept);
		empRepo.save(emp);
	}

//	@Override
//	public Employee findByFullname(String firstname, String lastname) {
//		// TODO Auto-generated method stub
//		Employee e = empRepo.findByFirstnameIgnoreCaseAndLastnameIgnoreCase(firstname,lastname);
//		return e;
//	}

	@Override
	public Employee findByFirstnameAndLastname(String firstname, String lastname) {
		// TODO Auto-generated method stub
		Employee e = empRepo.findByFirstnameIgnoreCaseAndLastnameIgnoreCase(firstname, lastname);
		return e;
	}

	@Override
	public List<Employee> findByManager(Employee manager) {
		// TODO Auto-generated method stub
		return empRepo.findByManager(manager);
	}

	@Override
	public int countByDepartment(Department dept) {
		// TODO Auto-generated method stub
		List<Employee> empList = empRepo.findByDepartment(dept);
		return empList.size();
	}

	@Override
	public List<Employee> findByRole(Role r) {
		return empRepo.findByRole(r);
	}

	@Override
	public void removeFromRole(Employee emp) {
		emp.setRole(null);
		empRepo.save(emp);
	}

	@Override
	public int countByRole(Role role) {
		List<Employee> empList = empRepo.findByRole(role);
		return empList.size();
	}

	@Override
	public void removeFromDepartment(Employee emp, Department resourcePool) {
		// TODO Auto-generated method stub
		emp.setDepartment(resourcePool);
		empRepo.save(emp);
	}

	@Override
	public List<Employee> searchResourcePool(String name, Department dept) {
		// TODO Auto-generated method stub
		return empRepo.findByFirstnameIgnoreCaseContainingAndDepartment(name, dept);
	}

	@Override
	public List<Employee> findByFirstnameOrLastnameOrRoleOrDepartmentOrUserNameAllIgnoreCase(@Param("employeeName") String firstname, @Param("employeeName") String lastname, @Param("role") Role role,
			@Param("department") Department department, @Param("userID") String userName) {
		List<Employee> empList = empRepo.findByFirstnameOrLastnameOrRoleOrDepartmentOrUserNameAllIgnoreCase(firstname, lastname, role, department, userName);

		return empList;
	}

}
