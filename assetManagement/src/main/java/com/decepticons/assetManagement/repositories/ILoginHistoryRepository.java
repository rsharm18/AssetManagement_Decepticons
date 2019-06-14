package com.decepticons.assetManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.decepticons.assetManagement.entity.LoginHistory;

@RepositoryRestResource
public interface ILoginHistoryRepository extends JpaRepository<LoginHistory, Integer> {

	public List<LoginHistory> findByUsernameOrderByIdDesc(String userName);

}
