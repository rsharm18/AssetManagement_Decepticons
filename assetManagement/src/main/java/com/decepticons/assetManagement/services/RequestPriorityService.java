package com.decepticons.assetManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Request;
import com.decepticons.assetManagement.entity.RequestPrioity;
import com.decepticons.assetManagement.repositories.IRequestPriorityRepository;
import com.decepticons.assetManagement.services.protocols.IRequestPriorityService;

@Service
public class RequestPriorityService implements IRequestPriorityService
{

@Autowired
private IRequestPriorityRepository ReqPriRepo;

	@Override
	public List<RequestPrioity> findAll() {
		// TODO Auto-generated method stub
		return ReqPriRepo.findAll();
	}

	@Override
	public RequestPrioity findById(int Id) {
		Optional<RequestPrioity> result = ReqPriRepo.findById(Id);
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
	public void save(RequestPrioity requestpriory) {
		// TODO Auto-generated method stub
		ReqPriRepo.save(requestpriory);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		ReqPriRepo.deleteById(id);
	}
	
}
