package com.decepticons.assetManagement.controller;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.decepticons.assetManagement.entity.Inventory;
import com.decepticons.assetManagement.entity.InventoryInfo;
import com.decepticons.assetManagement.repositories.IDepartmentRepository;
import com.decepticons.assetManagement.repositories.IRoleRepository;
import com.decepticons.assetManagement.services.protocols.IInventoryInfoService;
import com.decepticons.assetManagement.services.protocols.IInventoryService;
import com.decepticons.assetManagement.util.AssetManagementUtil;



@Controller
@RequestMapping("/inventoryInfo")
public class InventoryInfoController {

	@Autowired
	private IInventoryInfoService invService;
	
	@Autowired
	private IDepartmentRepository deptRepo;
	
	@Autowired
	private IRoleRepository roleRepo;
	
	private List<InventoryInfo> invs;
	
	@PostConstruct
	public void loadData()
	{
		invs = new ArrayList<InventoryInfo>(invService.findAll());
	}

	
	@GetMapping("/list")
	public String listInventory(Model model)
	{
		loadData();
		model.addAttribute("inventoryInfo", invs);
		return "list-InventoriesInfo";
		
	}
	
	@PostMapping("/search")
	public String searchByAsset(@RequestParam("asset") String asset, Model model) {
		List<InventoryInfo> invs = invService.findByAsset(asset);
		model.addAttribute("invs",invs);
		return "inventoryInfo/list-search";
	}
	
	@PostMapping("/searchDate")
	public String searchByDate(@RequestParam("dt") Date dt, Model model) {
		List<InventoryInfo> invs = invService.findByPDate(dt);
		model.addAttribute("invs",invs);
		return "inventoryInfo/list-search";
	}
	
	@PostMapping("/searchVendor")
	public String searchByVendor(@RequestParam("vendor") String vname, Model model) {
		List<InventoryInfo> invs = invService.findByVendor(vname);
		model.addAttribute("invs",invs);
		return "inventoryInfo/list-search";
	}
	
	@PostMapping("/searchStatus")
	public String searchByStatus(@RequestParam("status") String status, Model model) {
		List<InventoryInfo> invs = invService.findByStatus(status);
		model.addAttribute("invs",invs);
		return "inventoryInfo/list-search";
	}
	
	
	@GetMapping("/searchOption") 
	public String searchOption(Model model) {
		model.addAttribute("invs",invs);
		return "inventoryInfo/searchOption";
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		InventoryInfo in = new InventoryInfo();
		model.addAttribute("invRecord", in);
		model.addAttribute("departments", deptRepo.findAll());
		model.addAttribute("roles", roleRepo.findAll());
		return "inventoryInfo/InventoryInfoFormAdd";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("inventory_id") int id, Model model)
	{
		InventoryInfo in = invService.findById(id);
		
		model.addAttribute("invRecord",in);
		model.addAttribute("departments", deptRepo.findAll());
		model.addAttribute("roles", roleRepo.findAll());
		return "inventoryInfo/InventoryInfoForm";
	}
	
	
	@PostMapping("/save")
	public String saveEmployeeData(@ModelAttribute("invRecord") InventoryInfo in)
	{
		
		System.out.println("saving.. "+in);
		System.out.println("saving.. "+in.getInv());
		invService.updateInventory(in);
		
		System.out.println("Saved "+in);
		return "redirect:/inventoryInfo/list";
	}
	
	@PostMapping("/add")
	public String addEmployeeData(@ModelAttribute("invRecord") InventoryInfo in)
	{
				
		invService.save(in);
		System.out.println("Added "+in);
		return "redirect:/inventoryInfo/list";
	}
	
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("inventory_id") int Id, Model model)
	{
		InventoryInfo in = invService.findById(Id);
		
		invService.deleteById(Id);
		
		System.out.println("Deleted "+in);
		return "redirect:/inventoryInfo/list";
	}
	
	
}
