package com.decepticons.assetManagement.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
		List<String> graphName = new ArrayList<String>();
		List<Integer> graphEmpData = new ArrayList<Integer>();
		List<Integer> graphManData = new ArrayList<Integer>();
		
		for(Department d : departments) {
			graphName.add(d.getDeptName());
			graphEmpData.add(empService.countByDepartment(d));
			graphManData.add(deptManService.countManagerByDepartment(d));
		}
		model.addAttribute("graphName", graphName);
		model.addAttribute("graphEmpData", graphEmpData);
		model.addAttribute("graphManData", graphManData);
		model.addAttribute("scaleMax", Math.max(Collections.max(graphEmpData), Collections.max(graphManData))+2);	
		return "list-Departments";		
	}
	
	@GetMapping("/detail")
	public String deptDetail(@RequestParam("deptid") int deptid, Model model) {
		Department dept = deptService.findById(deptid);
		List<Employee> empList = empService.findByDepartment(dept);
		List<DepartmentManager> manList = deptManService.findByDeptId(dept);
		model.addAttribute("manList", manList);
		model.addAttribute("dept", dept);
		model.addAttribute("empList", empList);
		return "departments/DepartmentDetail";
	}
	
	@GetMapping("/AddDepartment")
	public String addDept(Model model) {
		Department deptForm = new Department();
		model.addAttribute("deptForm", deptForm);		
		return "departments/DepartmentForm";
	}
	
	@PostMapping("/save")
	public String saveDept(@ModelAttribute("deptForm") Department dept) {
		deptService.saveDepartment(dept);
		return "redirect:/departments/list";
	}
	
	@GetMapping("/UpdateDepartment")
	public String updateDept(@RequestParam("deptid") int Id, Model model)	{		
		Department dept = deptService.findById(Id);
		model.addAttribute("deptUpdate", dept);
		return "departments/DepartmentUpdate";
	}
	
	@PostMapping("/update")
	public String updateDept(@ModelAttribute("deptUpdate") Department dept) {
		deptService.updateDepartment(dept);
		return "redirect:/departments/list";
	}
	
	@PostMapping("/search")
	public String searchByName(@RequestParam("deptName") String name, Model model) {
		List<Department> departments = deptService.findByDeptNameIgnoreCaseContaining(name);
		model.addAttribute("name", name);
		model.addAttribute("departments", departments);
		return "/departments/DepartmentSearch";
	}
	
	@GetMapping("/delete")
	public String deleteDept(@RequestParam("deptid") int id) {
		Department dept = deptService.findById(id);		
		List<Employee> empList = empService.findByDepartment(dept);
		List<Department> deptList = deptService.findByDeptNameIgnoreCaseContaining("resource pool");
		Department resourcePool = deptList.get(0);
		for(Employee e : empList) {
			empService.removeFromDepartment(e, resourcePool);
		}		
		List<DepartmentManager> manList = deptManService.findByDeptId(dept);
		for(DepartmentManager m : manList) {
			deptManService.deleteManagerById(m.getDeptmanagerid());
		}		
		deptService.deleteDepartment(dept);	
		return "redirect:/departments/list";
	}
	
	@GetMapping("/AddManager")
	public String addManager(@RequestParam("deptid") int id, Model model) {
		Department dept = deptService.findById(id);
		model.addAttribute("dept", dept);		
		List<Employee> empList = empService.findAll();
		List<DepartmentManager> manList = deptManService.findByDeptId(dept);
		for(DepartmentManager m : manList) {
			if (empList.contains(m.getDeptEmpId())) {
				empList.remove(m.getDeptEmpId());
			}
		}
		model.addAttribute("manList", empList);	
		return "departments/DepartmentManagerTable";
	}
	
	@GetMapping("/saveManager")
	public String saveMan(@RequestParam("deptid") int id, @RequestParam("empid") int empid) {
		DepartmentManager deptMan = new DepartmentManager();
		deptMan.setDeptId(deptService.findById(id));
		deptMan.setDeptEmpId(empService.findById(empid));
		deptManService.saveManager(deptMan);	
		return "redirect:/departments/detail?deptid=" + id;
	}
	
	
	@GetMapping("/removeManager")
	public String removeMan(@RequestParam("empid") int empid, @RequestParam("deptid") int deptid) {
		Department d = deptService.findById(deptid);
		Employee e = empService.findById(empid);
		DepartmentManager m = deptManService.findByDeptIdAndDeptEmpId(d, e);
		deptManService.deleteManagerById(m.getDeptmanagerid());
		return "redirect:/departments/detail?deptid=" + deptid;
	}
	
	@GetMapping("/AddEmployee")
	public String addEmployee(@RequestParam("deptid") int id, Model model) {
		Department dept = deptService.findResourcePool();
		List<Employee> empList = empService.findByDepartment(dept);
		Department desDept = deptService.findById(id);
		model.addAttribute("empList", empList);
		model.addAttribute("dept", dept);
		model.addAttribute("desDept", desDept);		
		return "/departments/DepartmentEmployeePool";
	}
	
	@GetMapping("/saveEmployee")
	public String saveEmployee(@RequestParam("deptid") int id, @RequestParam("empid") int empid) {
		Department dept = deptService.findById(id);
		Employee emp = empService.findById(empid);
		empService.addToDepartment(emp, dept);
		return "redirect:/departments/detail?deptid=" +id;
	}
	
	@GetMapping("/removeEmployee")
	public String removeEmployee(@RequestParam("empid") int empid, @RequestParam("deptid") int deptid) {
		Employee emp = empService.findById(empid);
		List<Department> deptList = deptService.findByDeptNameIgnoreCaseContaining("resource pool");
		Department resourcePool = deptList.get(0);
		empService.removeFromDepartment(emp, resourcePool);		
		return "redirect:/departments/detail?deptid=" + deptid;
	}

	@PostMapping("/resourceSearch")
	public String searchResource(@RequestParam("deptid") int deptid, @RequestParam("resourceName") String name, Model model) {
		List<Department> deptList = deptService.findByDeptNameIgnoreCaseContaining("resource pool");
		Department resourcePool = deptList.get(0);
		List<Employee> empList = empService.searchResourcePool(name, resourcePool);		
		Department desDept = deptService.findById(deptid);
		model.addAttribute("empList", empList);
		model.addAttribute("desDept", desDept);	
		return "/departments/DepartementResourceSearch";
	}
	
}











