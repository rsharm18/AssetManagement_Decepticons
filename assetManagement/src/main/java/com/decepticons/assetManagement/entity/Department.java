package com.decepticons.assetManagement.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the DEPARTMENTS database table.
 * 
 */
@Data
@Entity
@Table(name = "Departments")
public class Department {
	
	@Getter
	@Setter
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_DeptSequence")
	@SequenceGenerator(name = "id_DeptSequence", sequenceName = "DEPTS_ID_SEQ", allocationSize = 1)
	@Column(name = "dept_id")
	private long deptId;

	@Column(name = "dept_name")
	private String deptName;

	// bi-directional many-to-one association to Employee
	@OneToMany(mappedBy = "department")
	private List<Employee> employees;
	
	@Override
	public String toString()
	{
		return getDeptId()+" - "+getDeptName();
	}

}