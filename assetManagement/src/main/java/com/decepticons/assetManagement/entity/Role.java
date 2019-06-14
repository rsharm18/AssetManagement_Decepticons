package com.decepticons.assetManagement.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the "ROLES" database table.
 * 
 */
@Data
@Entity
@Table(name = "roles")
public class Role {

	@Getter
	@Setter
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ROLES_ID_SEQ", allocationSize = 1)
	@Column(name = "role_id")
	private int id;

	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "role_access")
	private String roleAccess;
	
	@OneToMany(mappedBy = "role")
	private List<Employee> employees;
	
	@Override
	public String toString() {
		return "Role [getId()="+ getId() + ", getRoleName()=" + getRoleName() + ", getRoleAccess()=" + getRoleAccess() + "]";
				}
	


}