package com.decepticons.assetManagement.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
import com.decepticons.assetManagement.entity.DepartmentManager;
import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.services.protocols.IDepartmentManagerService;
import com.decepticons.assetManagement.services.protocols.IDepartmentService;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private IDepartmentService deptService;
	@Autowired
	private IEmployeeService empService;
	
	@Autowired
	private IDepartmentManagerService deptManService;
	
	private List<Department> departments;

	
	@PostConstruct
	public void loadData()
	{
		departments = new ArrayList<Department>(deptService.findAll());		
	}
	
	
	@GetMapping("/list")
	public String listDepartments(Model model)
	{
		loadData();
		model.addAttribute("departments", departments);
		return "list-Departments";		
	}
	
	@GetMapping("/detail")
	public String deptDetail(@RequestParam("deptid") int deptid, Model model) {
		Department dept = deptService.findById(deptid);
		List<Employee> empList = empService.findByDepartment(dept);
		List<Object[]> manList = deptManService.findByDeptman(deptid);
		System.out.println("=============================");
//		System.out.println(manList.get(0)[0]);
		System.out.println("size: " + manList.size());
		model.addAttribute("dept", dept);
		model.addAttribute("empList", empList);
		model.addAttribute("manList", manList);
		
		return "departments/DepartmentDetail";
	}
}
