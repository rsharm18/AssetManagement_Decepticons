package com.decepticons.assetManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.Request;
import com.decepticons.assetManagement.repositories.IEmployeeRepository;
import com.decepticons.assetManagement.repositories.IRequestRepository;
import com.decepticons.assetManagement.services.protocols.IRequestService;

@Service
public class RequestService implements IRequestService
{
	
	@Autowired
	private IRequestRepository reqRepo;
	@Autowired
	private IEmployeeRepository empRepo;
	
	public RequestService()
	{
		
	}
	@Override
	public List<Request> findAll() {
		// TODO Auto-generated method stub
		return reqRepo.findAll();
	}

	@Override
	public Request findById(int Id) {
		// TODO Auto-generated method stub
		Optional<Request> result = reqRepo.findById(Id);
		if(result.isPresent())
		{
			return result.get();
		}
		else
		{
			throw new RuntimeException("Request not found witn ID=" + Id); 
		}
	}

	@Override
	public void save(Request request) {
		reqRepo.save(request);
	}

	@Override
	public void deleteById(int id) {
		reqRepo.deleteById(id);
	}
//	@Override
//	public List<Request> getAllRequests(String requestfirstname) {
//		// TODO Auto-generated method stub
//		return reqRepo.findByRequestfirstname(requestfirstname);
//	}
	
	@Override
	public List<Request> findRequestByEmpId(Employee e){
		return reqRepo.findByRequestempid(e);
	}
//	@Override
//	public List<Request> findRequestByRequestStatus(String status) {
//		// TODO Auto-generated method stub
//		return reqRepo.findByRequestrequeststatus(status);
//	}
	@Override
	public List<Request> findByRequestdepartmentname(String name) {
		// TODO Auto-generated method stub
		List<Request> dept = reqRepo.findByRequestdepartmentnameIgnoreCase(name);
		return dept;
	}
	@Override
	public List<Request> findByRequestdepartmentnameAndRequeststatus(String name, String status) {
		// TODO Auto-generated method stub
		List<Request> req = reqRepo.findByRequestdepartmentnameIgnoreCaseAndRequeststatusIgnoreCase(name,status);
		return req;
	}
//	@Override
//	public Employee findById(Integer requestempid) {
//		// TODO Auto-generated method stub
//		Optional<Employee> e = empRepo.findById(requestempid);
//		if(e.isPresent())
//		{
//			return e.get();
//		}
//		else
//		{
//			throw new RuntimeException("Request not found witn ID=" + requestempid); 
//		}
//	}
}
