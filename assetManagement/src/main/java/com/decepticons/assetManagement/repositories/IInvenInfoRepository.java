package com.decepticons.assetManagement.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.InventoryInfo;

import java.sql.Date;
import java.util.List;

@RepositoryRestResource
public interface IInvenInfoRepository extends JpaRepository<InventoryInfo, Integer>{
	
	public List<InventoryInfo> findByNameOfAsset(String Asset);
	public List<InventoryInfo>  findByAssetStatus(String status);
	public  List<InventoryInfo> findByVName(String vendor);
	public  List<InventoryInfo> findByPurchaseDate(Date dt);
}
