package com.decepticons.assetManagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
import com.decepticons.assetManagement.entity.Request;
import com.decepticons.assetManagement.entity.RequestPrioity;
import com.decepticons.assetManagement.repositories.IRequestPriorityRepository;
import com.decepticons.assetManagement.services.protocols.IRequestPriorityService;



@Controller
@RequestMapping("/requestsPriority")
public class RequestPriorityController {
	
	  @Autowired
	  private IRequestPriorityService reqService;
	  
	  @Autowired
	  private IRequestPriorityRepository reqRepo;
	  
	  
	  private List<RequestPrioity> requestprioitys;
	  
	  @PostConstruct 
	  public void loadData()
	  {
		  requestprioitys = new ArrayList<RequestPrioity>(reqService.findAll());
	 }
	  
	  
	
	  @GetMapping("/list")
	  public String listRequestPrioritys(Model model)
	  {
	  loadData(); 
	  model.addAttribute("requestpriorites", requestprioitys); 
	  return "list-RequestPriorites";
	  
	  }
	 
	  @GetMapping("/showFormForAdd")
		public String showAddForm(Model model)
		{
		   RequestPrioity req = new RequestPrioity();
			model.addAttribute("reqRecord", req);
			return "requestprioritys/RequestPriorityForm";
		}
		
		
		
		
		@PostMapping("/save")
		public String saveRequestData(@ModelAttribute("reqRecord") RequestPrioity req)
		{
			reqService.save(req);
			System.out.println("Saved "+req);
			return "redirect:/requestsPriority/list";
		}
		
		
		
		@GetMapping("/showForForUpdate")
		public String showFormForUpdate(@RequestParam("priorityid") int Id, Model model)
		{
			RequestPrioity req = reqService.findById(Id);
			model.addAttribute("reqRecord",req);
			return "requestprioritys/RequestPriorityForm";
		}

		
	

		@GetMapping("/deleteRecord")
		public String deleteRecord(@RequestParam("priorityid") int Id, Model model)
		{
			RequestPrioity req = reqService.findById(Id);
			
			reqService.deleteById(Id);
			
			System.out.println("Deleted "+req);
			return "redirect:/requestsPriority/list";
		}
		
	
		

		
		
	

	
	
}
