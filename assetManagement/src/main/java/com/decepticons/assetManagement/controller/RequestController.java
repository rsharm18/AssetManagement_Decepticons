package com.decepticons.assetManagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.DepartmentManager;
import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.Request;
import com.decepticons.assetManagement.repositories.IDepartmentRepository;
import com.decepticons.assetManagement.repositories.IEmployeeRepository;
import com.decepticons.assetManagement.repositories.IRequestRepository;
import com.decepticons.assetManagement.services.protocols.IDepartmentManagerService;
import com.decepticons.assetManagement.services.protocols.IDepartmentService;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;
import com.decepticons.assetManagement.services.protocols.IRequestPriorityService;
import com.decepticons.assetManagement.services.protocols.IRequestService;
import com.decepticons.assetManagement.services.protocols.IRequestStatusService;
import com.decepticons.assetManagement.services.protocols.IRequestSubTypesService;
import com.decepticons.assetManagement.services.protocols.IRequestTypesService;
import com.decepticons.assetManagement.util.SessionObject;

@Controller
@RequestMapping("/requests")
@Scope("session")
@SessionAttributes("user")
public class RequestController {

	@Autowired
	private IRequestService reqService;
	@Autowired
	private IDepartmentRepository deptRepo;
	@Autowired
	private IEmployeeRepository empRepo;
	@Autowired
	private IRequestRepository reqRepo;
	@Autowired
	private IRequestTypesService reqtypeRepo;
	@Autowired
	private IRequestSubTypesService reqsubtypeRepo;
	@Autowired
	private IRequestStatusService reqstatusRepo;
	@Autowired
	private IDepartmentManagerService deptManService;
	@Autowired
	private IEmployeeService empService;
	@Autowired
	private IDepartmentService deptService;
	@Autowired
	private IRequestPriorityService reqpriRepo;

	private List<Request> requests;

	public SessionObject sessionObject;

	@PostConstruct
	public void loadData() {
		requests = new ArrayList<Request>(reqService.findAll());
	}

	@GetMapping("/list")
	public String listRequests(Model model) {
		loadData();
		model.addAttribute("requests", requests);
		return "list-Requests";

	}

	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model) {
		Request req = new Request();
		model.addAttribute("reqRecord", req);
		model.addAttribute("requestprioritys", reqpriRepo.findAll());
		// department name in ascending order
		model.addAttribute("departments", deptRepo.findAll(new Sort(Sort.Direction.ASC, "deptName")));
		model.addAttribute("requesttypes", reqtypeRepo.findAll());
		model.addAttribute("requestsubtypes", reqsubtypeRepo.findAll());
		model.addAttribute("requestsstate", reqstatusRepo.findAll());
		model.addAttribute("emp", empService.findByDepartment(req.getRequestdepartmentid()));
		return "requests/RequestForm";
	}

	@PostMapping("/save")
	public String saveRequestData(@ModelAttribute("reqRecord") Request req) {
		// List<Department> d = deptRepo.findByDeptName(req.getRequestdepartmentname());
		Department d = deptRepo.findByDeptName(req.getRequestdepartmentname());
		req.setRequestdepartmentid(d);
//		for(Department sam:d)
//		{
//			req.setRequestdepartmentid(sam);
//		}
		Employee e = empRepo.findByFirstnameIgnoreCaseAndLastnameIgnoreCase(req.getRequestfirstname(), req.getRequestlastname());

		req.setRequestempid(e);
		reqService.save(req);
		System.out.println("Saved " + req);
		return "redirect:/requests/list";
	}

	@PostMapping("/search")
	public String searchByName(@RequestParam("requestdepartmentname") String name, @RequestParam("requeststatus") String status, Model model) {
		// List<Request> requests = reqService.findByRequestdepartmentname(name);
		List<Request> request1 = reqService.findByRequestdepartmentnameAndRequeststatus(name, status);
		model.addAttribute("name", name);
		model.addAttribute("status", status);
		model.addAttribute("requests", request1);
		return "requests/RequestSearch";
	}

	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("requestid") int Id, Model model) {
		Request req = reqService.findById(Id);
		model.addAttribute("requestprioritys", reqpriRepo.findAll());
		model.addAttribute("reqRecord", req);
		model.addAttribute("requesttypes", reqtypeRepo.findAll());
		model.addAttribute("requestsubtypes", reqsubtypeRepo.findAll());
		model.addAttribute("departments", deptRepo.findAll(new Sort(Sort.Direction.ASC, "deptName")));
		model.addAttribute("requestsstate", reqstatusRepo.findAll());
		return "requests/RequestForm";
	}

	@GetMapping("/approve")
	public String approved(@RequestParam("requestid") int Id, Model model) {
		Request req = reqService.findById(Id);
		req.setRequeststatus("In-Progress");
		model.addAttribute("reqRecord", req);
		reqService.save(req);
		return "/requests/approve";
	}

	@GetMapping("/reject")
	public String rejected(@RequestParam("requestid") int Id, Model model) {
		Request req = reqService.findById(Id);
		req.setRequeststatus("Completed");
		model.addAttribute("reqRecord", req);
		reqService.save(req);
		return "/requests/reject";
	}

	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("requestid") int Id, Model model) {
		Request req = reqService.findById(Id);

		reqService.deleteById(Id);

		System.out.println("Deleted " + req);
		return "redirect:/requests/list";
	}

	@GetMapping("/managers")
	public String getManagerList(@ModelAttribute("user") SessionObject session_emp, Model model) {

		List<DepartmentManager> manList = new ArrayList<DepartmentManager>();
		if (session_emp != null && session_emp.getUser() != null && !session_emp.getUser().getRole().getRoleName().equalsIgnoreCase("Admin")) {
			Department dept = session_emp.getUser().getDepartment();

			manList = deptManService.findByDeptId(dept);

		} else {
			manList = deptManService.findAll();
		}
		System.out.println(" session_emp " + session_emp);
		// List<DepartmentManager> manList = deptManService.findAll();

		model.addAttribute("manList", manList);
		return "/requests/ManagerList";
	}

	@GetMapping("/ManagerRequests")
	public String managerRequestList(@RequestParam("deptid") int deptid, @RequestParam("empid") int empid, Model model) {
		List<Request> reqList = new ArrayList<Request>();
		Employee man = empService.findById(empid);

		List<Employee> empList = empService.findByManager(man);

		for (Employee e : empList) {
			System.out.println(e.getId());
			List<Request> r = reqRepo.findByRequestempid(e);

//			List<Request> r = reqService.findRequestByEmpId(e.getId());
			if (!(r.isEmpty())) {
				for (Request req : r) {
					if (req.getRequeststatus().equalsIgnoreCase("New") || req.getRequeststatus().equalsIgnoreCase("Pending")) {
						Request result = req;
						reqList.add(result);
					}
				}
//				reqList.addAll(r);
			}
		}
		model.addAttribute("empList", empList);
		model.addAttribute("reqList", reqList);
		model.addAttribute("man", man);
		return "/requests/RequestList";
	}

}
