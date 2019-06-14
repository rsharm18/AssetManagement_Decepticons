package com.decepticons.assetManagement.services.protocols;
import java.sql.Date;
import java.util.List;
import com.decepticons.assetManagement.entity.InventoryInfo;

public interface IInventoryInfoService {

	public List<InventoryInfo> findAll();
	public InventoryInfo findById(int id);
	public  List<InventoryInfo> findByAsset(String asset);
	public  List<InventoryInfo> findByStatus(String status);
	public  List<InventoryInfo> findByVendor(String vendor);
	public  List<InventoryInfo> findByPDate(Date dt);
	public void save(InventoryInfo inv);
	public void deleteById(int id);
	public void updateInventory(InventoryInfo inv);
}

