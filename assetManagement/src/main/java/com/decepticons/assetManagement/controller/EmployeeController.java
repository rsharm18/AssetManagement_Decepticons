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

import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;



@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private IEmployeeService empService;
	
	private List<Employee> employees;
	
	@PostConstruct
	public void loadData()
	{
		employees = new ArrayList<Employee>(empService.findAll());
	}

	
	@GetMapping("/list")
	public String listEmployees(Model model)
	{
		loadData();
		model.addAttribute("employees", employees);
		return "list-Employees";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		Employee emp = new Employee();
		model.addAttribute("empRecord", emp);
		
		return "employees/EmployeeForm";
	}
	
	@PostMapping("/save")
	public String saveEmployeeData(@ModelAttribute("empRecord") Employee emp)
	{
		empService.save(emp);
		
		System.out.println("Saved "+emp);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("employeeid") int Id, Model model)
	{
		Employee emp = empService.findById(Id);
		model.addAttribute("empRecord",emp);
		
		return "employees/EmployeeForm";
	}
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("employeeid") int Id, Model model)
	{
		Employee emp = empService.findById(Id);
		
		empService.deleteById(Id);
		
		System.out.println("Deleted "+emp);
		return "redirect:/employees/list";
	}
	
	
}
