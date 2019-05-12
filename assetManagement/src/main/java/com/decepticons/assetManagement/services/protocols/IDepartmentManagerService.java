package com.decepticons.assetManagement.services.protocols;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.DepartmentManager;

public interface IDepartmentManagerService {

	public List<Object[]> findByDeptman(int id);



}
