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

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.services.protocols.IDepartmentService;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private IDepartmentService deptService;
	private IEmployeeService empService;
	
	private List<Department> departments;
	private Employee man;
	private String msg = "secret2";
	
	@PostConstruct
	public void loadData()
	{
		departments = new ArrayList<Department>(deptService.findAll());
		
		
	}
	
	
	@GetMapping("/list")
	public String listDepartments(Model model)
	{
		loadData();
		model.addAttribute("msg", msg);
		model.addAttribute("departments", departments);
//		Employee man = deptService.findManagerById();
		
		return "list-Departments";		
	}
	
//	public String findManager(@RequestParam("employeeid") int id, Model model) {
//		man = empService.findById(id);	
//		model.addAttribute("man", man);
//		return "manager";
//	}
}
