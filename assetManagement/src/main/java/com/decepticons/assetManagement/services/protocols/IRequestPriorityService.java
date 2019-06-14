package com.decepticons.assetManagement.services.protocols;

import java.util.List;


import com.decepticons.assetManagement.entity.RequestPrioity;


public interface IRequestPriorityService {

	public List<RequestPrioity> findAll();

	public RequestPrioity findById(int Id);
	public void save (RequestPrioity requestpriory);
	public void deleteById(int id);


}
