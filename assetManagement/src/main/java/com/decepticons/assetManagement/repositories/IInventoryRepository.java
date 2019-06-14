package com.decepticons.assetManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.decepticons.assetManagement.entity.Inventory;
import com.decepticons.assetManagement.entity.InventoryInfo;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface IInventoryRepository extends JpaRepository<Inventory, Integer>{

	public List<Inventory> findByNameOfAsset(String Asset);
	public  List<Inventory> findByAllocationStatus(String status);
	public  List<Inventory> findByDeptId(int dept);
	public  List<Inventory> findByAuthManager(String manager);
}
