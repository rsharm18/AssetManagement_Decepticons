package com.decepticons.assetManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.repositories.IUserAuthRepository;

@SpringBootApplication
public class AssetManagementApplication implements  CommandLineRunner {

	@Autowired
	private IUserAuthRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(AssetManagementApplication.class, args);
		
		//Employee emp = new Employee("Ravi", "Sharma", "a@a.c");
		//System.out.println(emp.getEmail());
	}
	
	@Override
	public void run(String ...strings) throws Exception
	{
		System.out.println(" MOngo "+userRepo.findAll());
	}

}
