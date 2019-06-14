package com.decepticons.assetManagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.decepticons.assetManagement.entity.RequestPrioity;

@RepositoryRestResource
public interface IRequestPriorityRepository extends JpaRepository<RequestPrioity, Integer> {

	public Optional<RequestPrioity> findById(Integer id);
//	public List<Request> findByRequestempid(Employee e);
//	//public List<Request> findByRequestrequeststatus(String status);
//
//	public List<Request> findByRequestdepartmentnameIgnoreCase(String name);
//
//	
//
//	public List<Request> findByRequestdepartmentnameIgnoreCaseAndRequeststatusIgnoreCase(String name, String status);
//
//	//public Employee findbyId(Integer requestempid);

}
