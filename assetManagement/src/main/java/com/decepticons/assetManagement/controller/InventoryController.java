package com.decepticons.assetManagement.controller;
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
import com.decepticons.assetManagement.repositories.IDepartmentRepository;
import com.decepticons.assetManagement.repositories.IRoleRepository;
import com.decepticons.assetManagement.services.protocols.IInventoryService;
import com.decepticons.assetManagement.util.AssetManagementUtil;



@Controller
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private IInventoryService invService;
	
	@Autowired
	private IDepartmentRepository deptRepo;
	
	@Autowired
	private IRoleRepository roleRepo;
	
	private List<Inventory> invs;
	@PostConstruct
	public void loadData()
	{
		invs = new ArrayList<Inventory>(invService.findAll());
	}

	
	@GetMapping("/list")
	public String listInventory(Model model)
	{
		loadData();
		model.addAttribute("inventory", invs);
		return "list-Inventories";
		
	}

	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		Inventory in = new Inventory();
		model.addAttribute("invRecord", in);
		model.addAttribute("departments", deptRepo.findAll());
		model.addAttribute("roles", roleRepo.findAll());
		return "inventory/InventoryFormAdd";
	}
	
	@PostMapping("/search")
	public String searchByAsset(@RequestParam("asset") String asset, Model model) {
		List<Inventory> invs = invService.findByAsset(asset);
		model.addAttribute("invs",invs);
		return "inventory/list-search";
	}
	
	@PostMapping("/searchDept")
	public String searchByDept(@RequestParam("dept") int dept, Model model) {
		List<Inventory> invs = invService.findByDept(dept);
		model.addAttribute("invs",invs);
		return "inventory/list-search";
	}
	
	@PostMapping("/searchManager")
	public String searchByManager(@RequestParam("man") String man, Model model) {
		List<Inventory> invs = invService.findByManager(man);
		model.addAttribute("invs",invs);
		return "inventory/list-search";
	}
	
	@PostMapping("/searchStatus")
	public String searchById(@RequestParam("status") String status, Model model) {
		List<Inventory> invs = invService.findByStatus(status);
		model.addAttribute("invs",invs);
		return "inventory/list-search";
	}
	
	@GetMapping("/searchOption")
	public String searchOption(Model model) {
		model.addAttribute("invs",invs);
		return "inventory/searchOption";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("inventory_id") int id, Model model)
	{
		Inventory in = invService.findById(id);
		
		model.addAttribute("invRecord",in);
		model.addAttribute("departments", deptRepo.findAll());
		model.addAttribute("roles", roleRepo.findAll());
		return "inventory/InventoryForm";
	}
	
	
	@PostMapping("/save")
	public String saveEmployeeData(@ModelAttribute("invRecord") Inventory in)
	{
		
		System.out.println("saving.. "+in);
		
		invService.updateInventory(in);
		
		System.out.println("Saved "+in);
		return "redirect:/inventory/list";
	}
	
	@PostMapping("/add")
	public String addEmployeeData(@ModelAttribute("invRecord") Inventory in)
	{
				
		invService.save(in);
		System.out.println("Added "+in);
		return "redirect:/inventory/list";
	}
	
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("inventory_id") int Id, Model model)
	{
		Inventory in = invService.findById(Id);
		
		invService.deleteById(Id);
		
		System.out.println("Deleted "+in);
		return "redirect:/inventory/list";
	}
	
	
}
