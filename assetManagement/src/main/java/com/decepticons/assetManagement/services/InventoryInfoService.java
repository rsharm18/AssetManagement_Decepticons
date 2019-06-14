package com.decepticons.assetManagement.services;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Inventory;
import com.decepticons.assetManagement.entity.InventoryInfo;
import com.decepticons.assetManagement.repositories.IInvenInfoRepository;
import com.decepticons.assetManagement.repositories.IUserAuthRepository;
import com.decepticons.assetManagement.services.protocols.IInventoryInfoService;
import com.decepticons.assetManagement.services.protocols.IUserAuthService;
import com.decepticons.assetManagement.util.AssetManagementUtil;

@Service
public class InventoryInfoService implements IInventoryInfoService {

	private static AssetManagementUtil util = AssetManagementUtil.getFormatter();
	
	@Autowired
	private IInvenInfoRepository invRepo;
	
	@Autowired
	private IUserAuthRepository userAuthRepo;

	@Autowired
	private IUserAuthService userAuthService;

	public InventoryInfoService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<InventoryInfo> findAll() {
		// TODO Auto-generated method stub
		return invRepo.findAll();
	}

	@Override
	public List<InventoryInfo> findByAsset(String asset) {
		List<InventoryInfo> result = invRepo.findByNameOfAsset(asset);
		if (!result.isEmpty()) {
			return result;
		} else {
			throw new RuntimeException("Inventory not found with ID=" + asset);
		}
	}
	
	@Override
	public InventoryInfo findById(int id) {
		Optional<InventoryInfo> result = invRepo.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Inventory not found with ID=" + id);
		}
	}

	@Override
	public  List<InventoryInfo> findByStatus(String status)
	{
		List<InventoryInfo> result = invRepo.findByAssetStatus(status);
		if (!result.isEmpty()) {
			return result;
		} else {
			throw new RuntimeException("Inventory not found with ID=" + status);
		}
	}
	
	@Override
	public  List<InventoryInfo> findByVendor(String vendor)
	{
		List<InventoryInfo> result = invRepo.findByVName(vendor);
		if (!result.isEmpty()) {
			return result;
		} else {
			throw new RuntimeException("Inventory not found with ID=" + vendor);
		}
	}
	
	@Override
	public  List<InventoryInfo> findByPDate(Date dt)
	{
		List<InventoryInfo> result = invRepo.findByPurchaseDate(dt);
		if (!result.isEmpty()) {
			return result;
		} else {
			throw new RuntimeException("Inventory not found with ID=" + dt);
		}
	}
	/**
	 * updates only selected fields
	 */
	
	@Override
	public void updateInventory(InventoryInfo inv) {

		try {

			Method[] method = Class.forName(InventoryInfo.class.getName()).getMethods();
			for (Method m : method) {

				if (m.getName().startsWith("get") && !m.getName().equals("getId") && !m.getName().equals("getClass")) {
					// m.setAccessible(true);
					Object data = m.invoke(inv, null);

					// System.out.println(m.getName() + " Data " + data + " return type " +
					// m.getReturnType());

					if (data != null) {
						String methodName = m.getName().replace("get", "set");
						Method setter = Class.forName(InventoryInfo.class.getName()).getMethod(methodName,
								m.getReturnType());
//						System.out.println("invoke "+setter.getName());
						setter.invoke(inv, data);
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
	public void save(InventoryInfo inv) {

		invRepo.save(inv);

	}
	
	
	@Override
	public void deleteById(int id) {

		InventoryInfo inv = findById(id);
		if (inv != null) {
			invRepo.deleteById(id);
		}

	}
	
	/*@Override
	public List<Inventory> findByDepartment(int deptId) {
		// TODO Auto-generated method stub
		return invRepo.findByDepartment(deptId);
	}*/

}
