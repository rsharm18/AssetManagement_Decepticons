package com.decepticons.assetManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.decepticons.assetManagement.entity.Role;
import com.decepticons.assetManagement.services.protocols.IDepartmentService;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;
import com.decepticons.assetManagement.services.protocols.IRoleService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private IDepartmentService deptService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IEmployeeService empService;

	private List<Employee> employees;

	private static List<String> genderList = new ArrayList<String>();
	static {
		genderList.add("M");
		genderList.add("F");
	}

	@PostConstruct
	public void loadData() {
		employees = new ArrayList<Employee>(empService.findAll());
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {
		loadData();
		System.out.println("model " + model.toString());
		model.addAttribute("employees", employees);
		model.addAttribute("departments", deptService.findAll());
		model.addAttribute("roles", roleService.findAll());
		return "list-Employees";

	}

	@PostMapping("/search")
	public String searchEmployees(@RequestParam Map<String, String> reqParam, Model model)// @RequestParam("department") String department, @RequestParam("role") String
																							// role,@RequestParam("name") String name,@RequestParam("ssn") String ssn,Model
																							// model)
	{
		System.out.println("input map = " + reqParam);
		loadData();

		Department department = deptService.findById(Integer.parseInt(reqParam.get("department")));
		Role role = roleService.findById(Integer.parseInt(reqParam.get("role")));

		System.out.println("Searching Employee ++++++++++++++++");
		List<Employee> empList = empService.findByFirstnameOrLastnameOrRoleOrDepartmentOrUserNameAllIgnoreCase(reqParam.get("employeeName"), reqParam.get("employeeName"), role, department,
				reqParam.get("userID"));

		System.out.println("Filtered Employees " + empList);

		model.addAttribute("employees", empList);
		model.addAttribute("departments", deptService.findAll());
		model.addAttribute("roles", roleService.findAll());
		return "list-Employees";

	}

	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model) {
		Employee emp = new Employee();
		model.addAttribute("empRecord", emp);
		model.addAttribute("departments", deptService.findAll());
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("genderLIst", genderList);
		return "employees/EmployeeForm";
	}

	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("employeeid") int Id, Model model) {
		Employee emp = empService.findById(Id);

		model.addAttribute("empRecord", emp);
		model.addAttribute("departments", deptService.findAll());
		model.addAttribute("roles", roleService.findAll());
		return "employees/EmployeeForm";
	}

	@PostMapping("/save")
	public String saveEmployeeData(@ModelAttribute("empRecord") Employee emp, Model model) {

		System.out.println("saving.. " + emp);

		String msg = empService.updateEmployee(emp);

		model.addAttribute("pageMsg", msg);
		loadData();
		model.addAttribute("employees", employees);
		model.addAttribute("departments", deptService.findAll());
		model.addAttribute("roles", roleService.findAll());

		System.out.println("Saved " + emp);
		System.out.println(" msg " + msg);
		return "list-Employees";
	}

	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("employeeid") int Id, Model model) {
		Employee emp = empService.findById(Id);

		empService.deleteById(Id);

		System.out.println("Deleted " + emp);
		return "redirect:/employees/list";
	}

}
