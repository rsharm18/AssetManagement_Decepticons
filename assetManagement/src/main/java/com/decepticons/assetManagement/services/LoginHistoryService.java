package com.decepticons.assetManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.LoginHistory;
import com.decepticons.assetManagement.repositories.ILoginHistoryRepository;
import com.decepticons.assetManagement.services.protocols.ILoginHistoryService;
import com.decepticons.assetManagement.util.AssetManagementUtil;

@Service
public class LoginHistoryService implements ILoginHistoryService {

	private static AssetManagementUtil util = AssetManagementUtil.getFormatter();

	@Autowired
	private ILoginHistoryRepository loginHistoryRepo;

	public LoginHistoryService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<LoginHistory> findAll() {
		// TODO Auto-generated method stub
		return loginHistoryRepo.findAll();
	}

	@Override
	public List<LoginHistory> findByUsernameOrderByIdDesc(String userName) {
		return loginHistoryRepo.findByUsernameOrderByIdDesc(userName);
	}

	@Override
	public void save(LoginHistory loginHis) {
		loginHistoryRepo.save(loginHis);

	}

}
