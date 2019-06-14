package com.decepticons.assetManagement.services.protocols;
import java.util.List;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.Inventory;
import com.decepticons.assetManagement.entity.InventoryInfo;

public interface IInventoryService {

	public List<Inventory> findAll();
	public Inventory findById(int inv);
	public  List<Inventory> findByAsset(String asset);
	public  List<Inventory> findByStatus(String status);
	public  List<Inventory> findByDept(int dept);
	public  List<Inventory> findByManager(String manager);
	public void save(Inventory inv);
	public void deleteById(int id);
	public void updateInventory(Inventory inv);
	//public List<Inventory> findByDepartment(int deptId);
}

