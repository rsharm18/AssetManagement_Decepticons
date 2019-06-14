package com.decepticons.assetManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Role;
import com.decepticons.assetManagement.repositories.IRoleRepository;
import com.decepticons.assetManagement.services.protocols.IRoleService;

@Service
public class RoleService implements IRoleService
{
	@Autowired
	private IRoleRepository roleRepo;
	public RoleService(){}
	
	@Override
	public List<Role> findAll() {
		return roleRepo.findAll();
	}

	@Override
	public Role findById(int Id) {
		Optional<Role> result = roleRepo.findById(Id);
		if (result.isPresent()) {
			return result.get();
		} else {
			// throw new RuntimeException("Role not found with ID=" + Id);
			return null;
		}
	}

	@Override
	public void save(Role role) {
		roleRepo.save(role);
	}

	@Override
	public void deleteById(Role entity) {
		//roleRepo.deleteById(id);
		roleRepo.delete(entity);
	}

	@Override
	public List<Role> findRoleByName(String r){
		return roleRepo.findByRoleName(r);
	}

	@Override
	public void updateRole(Role role) {
		System.out.println(role.getId());
		System.out.println(role.getRoleName());
		roleRepo.save(role);
	}
	
//	@Override
//	public List<Role> findByRoleId(Role r) {
//		System.out.println("calling custom method");
//		return roleRepo.findByRoleId(r);
//	}

	
}
