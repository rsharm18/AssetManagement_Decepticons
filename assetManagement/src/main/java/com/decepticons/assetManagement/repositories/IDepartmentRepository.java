package com.decepticons.assetManagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.decepticons.assetManagement.entity.Department;

@RepositoryRestResource
public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

	public List<Department> findByDeptNameIgnoreCaseContaining(String name);

	public Department findByDeptName(String name);

}
