package com.decepticons.assetManagement.services.protocols;

import java.util.List;

import com.decepticons.assetManagement.entity.Role;


public interface IRoleService {

	public List<Role> findAll();

	public Role findById(int Id);
	public void save (Role role);
	public void deleteById(Role entity);
	public List<Role> findRoleByName(String name);
	public void updateRole(Role role);
}
