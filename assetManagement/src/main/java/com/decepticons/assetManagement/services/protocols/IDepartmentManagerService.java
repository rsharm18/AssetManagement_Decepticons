package com.decepticons.assetManagement.services.protocols;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.DepartmentManager;
import com.decepticons.assetManagement.entity.Employee;

public interface IDepartmentManagerService {

//	public List<Object[]> findByDeptman(int id);

	public List<DepartmentManager> findByDeptId(Department d) ;

	public void deleteManagerById(int id);

	public void saveManager(DepartmentManager deptMan);

	public DepartmentManager findByDeptIdAndDeptEmpId(Department d, Employee e);

	public int countManagerByDepartment(Department d);

}
