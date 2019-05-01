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

import com.decepticons.assetManagement.entity.UserAuth;
import com.decepticons.assetManagement.services.protocols.IUserAuthService;
import com.decepticons.assetManagement.util.AssetManagementUtil;



@Controller
@RequestMapping("/userAuth")
public class UserAuthController {

	
	
	@Autowired
	private IUserAuthService uAuthService;
	
	private List<UserAuth> userCredentials;
	
	@PostConstruct
	public void loadData()
	{
		userCredentials = new ArrayList<UserAuth>(uAuthService.findAll());
	}

	
	@GetMapping("/list")
	public String listUserAuths(Model model)
	{
		loadData();
		model.addAttribute("userCredentials", userCredentials);
		return "list-UserAuth";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model)
	{
		UserAuth userAuth = new UserAuth();
//		userAuth.setUserName(userName);
//		userAuth.setPassword(userName);
		
		model.addAttribute("empRecord", userAuth);
		
		return "userCredentials/UserAuthForm";
	}
	
	@PostMapping("/save")
	public String saveUserAuthData(@ModelAttribute("empRecord") UserAuth userAuth)
	{
		
		System.out.println("saving.. "+userAuth);
		
		uAuthService.save(userAuth);
		
		System.out.println("Saved "+userAuth);
		return "redirect:/userCredentials/list";
	}
	
	@GetMapping("/showForForUpdate")
	public String showFormForUpdate(@RequestParam("Id") String Id, Model model)
	{
		UserAuth userAuth = uAuthService.findById(Id);
		
		System.out.println("Saved "+userAuth);
		
		model.addAttribute("empRecord",userAuth);
		
		return "userCredentials/UserAuthForm";
	}
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(@RequestParam("Id") String Id, Model model)
	{
		UserAuth userAuth = uAuthService.findById(Id);
		
		uAuthService.deleteById(Id);
		
		System.out.println("Deleted "+userAuth);
		return "redirect:/userCredentials/list";
	}
	
	
}
