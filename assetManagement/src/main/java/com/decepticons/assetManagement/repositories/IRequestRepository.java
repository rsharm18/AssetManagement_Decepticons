package com.decepticons.assetManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.Request;

@RepositoryRestResource
public interface IRequestRepository extends JpaRepository<Request, Integer> {

	public List<Request> findByRequestempid(Employee e);
	//public List<Request> findByRequestrequeststatus(String status);

	public List<Request> findByRequestdepartmentnameIgnoreCase(String name);

	

	public List<Request> findByRequestdepartmentnameIgnoreCaseAndRequeststatusIgnoreCase(String name, String status);

	//public Employee findbyId(Integer requestempid);

}
