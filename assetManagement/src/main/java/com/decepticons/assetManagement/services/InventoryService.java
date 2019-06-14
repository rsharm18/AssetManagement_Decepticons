package com.decepticons.assetManagement.services;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import javax.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Inventory;
import com.decepticons.assetManagement.entity.InventoryInfo;
import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.UserAuth;
import com.decepticons.assetManagement.repositories.IInventoryRepository;
import com.decepticons.assetManagement.repositories.IEmployeeRepository;
import com.decepticons.assetManagement.repositories.IUserAuthRepository;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;
import com.decepticons.assetManagement.services.protocols.IInventoryService;
import com.decepticons.assetManagement.services.protocols.IUserAuthService;
import com.decepticons.assetManagement.util.AssetManagementUtil;

@Service
public class InventoryService implements IInventoryService {

	private static AssetManagementUtil util = AssetManagementUtil.getFormatter();
	
	@Autowired
	private IInventoryRepository invRepo;
	
	@Autowired
	private IUserAuthRepository userAuthRepo;

	@Autowired
	private IUserAuthService userAuthService;

	public InventoryService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Inventory> findAll() {
		// TODO Auto-generated method stub
		return invRepo.findAll();
	}

		
	@Override
	public Inventory findById(int inventory_id) {
		System.out.println("ID = "+inventory_id);
		Optional<Inventory> result = invRepo.findById(inventory_id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Inventory not found with ID=" + inventory_id);
		}
	}
	
	@Override
	public List<Inventory> findByAsset(String asset)
	 {
		List<Inventory> result = invRepo.findByNameOfAsset(asset);
		if (!result.isEmpty()) {
			return result;
		} else {
			throw new RuntimeException("Inventory not found with ID=" + asset);
		}
	}
	
	public  List<Inventory> findByStatus(String status)
	 {
		List<Inventory> result = invRepo.findByAllocationStatus(status);
		if (!result.isEmpty()) {
			return result;
		} else {
			throw new RuntimeException("Inventory not found with ID=" + status);
		}
	}
	
	public  List<Inventory> findByDept(int dept)
	 {
		List<Inventory> result = invRepo.findByDeptId(dept);
		if (!result.isEmpty()) {
			return result;
		} else {
			throw new RuntimeException("Inventory not found with ID=" + dept);
		}
	}
	
	public  List<Inventory> findByManager(String manager)
	 {
		List<Inventory> result = invRepo.findByAuthManager(manager);
		if (!result.isEmpty()) {
			return result;
		} else {
			throw new RuntimeException("Inventory not found with ID=" + manager);
		}
	}

	/**
	 * updates only selected fields
	 */
	
	@Override
	public void updateInventory(Inventory inv) {

		
		Inventory inve = findById(inv.getInv());
		try {

			Method[] method = Class.forName(Inventory.class.getName()).getMethods();
			for (Method m : method) {

				if (m.getName().startsWith("get") && !m.getName().equals("getId") && !m.getName().equals("getClass")) {
					// m.setAccessible(true);
					Object data = m.invoke(inv, null);

					// System.out.println(m.getName() + " Data " + data + " return type " +
					// m.getReturnType());

					if (data != null) {
						String methodName = m.getName().replace("get", "set");
						Method setter = Class.forName(Inventory.class.getName()).getMethod(methodName,
								m.getReturnType());
//						System.out.println("invoke "+setter.getName());
						setter.invoke(inve, data);
					}

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		save(inv);
	}
	
	@Override
	public void save(Inventory inv) {

		invRepo.save(inv);

	}
		
	
	@Override
	public void deleteById(int id) {
		Optional<Inventory> result = invRepo.findById(id);
		if (result.isPresent()) {
			invRepo.deleteById(id);
		} 
	}
	
	/*@Override
	public List<Inventory> findByDepartment(int deptId) {
		// TODO Auto-generated method stub
		return invRepo.findByDepartment(deptId);
	}*/

}
