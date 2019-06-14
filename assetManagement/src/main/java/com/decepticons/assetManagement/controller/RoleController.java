package com.decepticons.assetManagement.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.Role;
import com.decepticons.assetManagement.services.protocols.IRoleService;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;



@Controller
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	private List<Role> roles;
	
	@Autowired
	private IEmployeeService empService;	
	
	@PostConstruct
	public void loadData()
	{
		roles = new ArrayList<Role>(roleService.findAll());	
	}

	
	@GetMapping("/list")
	public String listRoles(Model model)
	{
		loadData();
		model.addAttribute("roles", roles);
		List<String> graphName = new ArrayList<String>();
		List<Integer> graphEmpData = new ArrayList<Integer>();
		for(Role r : roles) {
			graphName.add(r.getRoleName());
			graphEmpData.add(empService.countByRole(r));
		}
		model.addAttribute("graphName", graphName);
		model.addAttribute("graphEmpData", graphEmpData);
		model.addAttribute("scaleMax", Collections.max(graphEmpData)+2);
		
		return "list-Roles";		
	}
	
	@GetMapping("/detail")
	public String roleDetail(@RequestParam("roleid") int roleid, Model model) {
		Role role = roleService.findById(roleid);
		List<Employee> empList = empService.findByRole(role);
		//List<Role> roleList = roleService.findByRoleId(role);
		//model.addAttribute("roleList", roleList);
		model.addAttribute("role", role);
		model.addAttribute("empList", empList);
		return "roles/RoleDetail";
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		Role role = new Role();
		model.addAttribute("roleRecord", role);
		return "roles/RoleForm";
	}
	
	@PostMapping("/save")
	public String saveRoleData(@ModelAttribute("roleRecord") Role role)
	{
		roleService.save(role);
		
		System.out.println("Saved "+role);
		return "redirect:/roles/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("roleid") int Id, Model model)
	{
		Role role = roleService.findById(Id);
		model.addAttribute("roleRecord",role);
		
		return "roles/RoleForm";
	}
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("roleid") int Id, Model model)
	{
		Role role = roleService.findById(Id);		
		List<Employee> empList = empService.findByRole(role);
		for(Employee e : empList) {
			empService.removeFromRole(e);
		}	
		roleService.deleteById(role);
		model.addAttribute("role",role);
		System.out.println("Deleted "+role);
		return "redirect:/roles/list";
	}

	@RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET})
	public String search(@RequestParam(value = "roleName") String name, Model model) {
		List<Role> role = roleService.findRoleByName(name);
		model.addAttribute("name", name);
		model.addAttribute("roles", role);
		return "roles/RoleSearch2";
		
	}
	@GetMapping("/UpdateRoles")
	public String updateRoles(@RequestParam("roleid") int Id, Model model)	{		
		Role role = roleService.findById(Id);
		model.addAttribute("roleUpdate", role);
		return "roles/RoleUpdate";
	}
	
	@PostMapping("/update")
	public String updateRoles(@ModelAttribute("roleUpdate") Role role) {
		roleService.updateRole(role);
		return "redirect:/roles/list";
	}
	
	@GetMapping("/manage-Roles")
	public String showManageForm(Model model) {
		Role role = new Role();
		model.addAttribute("roleRecord", role);
		return "manage-Roles";
	}
	
	
	
	
	
}