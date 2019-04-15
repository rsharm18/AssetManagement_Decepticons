package com.decepticons.assetManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.repositories.IEmployeeRepository;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

			@Autowired
		private IEmployeeRepository empRepo;

		public EmployeeService() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public List<Employee> findAll() {
			// TODO Auto-generated method stub
			return empRepo.findAll();
		}

		@Override
		public Employee findById(int Id) {
			Optional<Employee> result = empRepo.findById(Id);
			if (result.isPresent()) {
				return result.get();
			} else {
				throw new RuntimeException("Employee not found witn ID=" + Id);
			}
		}

		@Override
		public void save(Employee employee) {
			empRepo.save(employee);

		}

		@Override
		public void deleteById(int id) {
			empRepo.deleteById(id);

		}

	
}
