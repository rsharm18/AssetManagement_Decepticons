package com.decepticons.assetManagement.services.protocols;

import java.util.List;

import com.decepticons.assetManagement.entity.LoginHistory;

public interface ILoginHistoryService {

	public List<LoginHistory> findAll();

	public List<LoginHistory> findByUsernameOrderByIdDesc(String userName);

	public void save(LoginHistory loginHis);

}
