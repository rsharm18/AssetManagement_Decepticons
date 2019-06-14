package com.decepticons.assetManagement.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "INV_ID_SEQ", allocationSize = 1)
	@Column(name = "inventory_id")
	private int inv;
	
	@Column(name = "name_Of_Asset")
	private String nameOfAsset;

	@Column(name = "allocation_status")
	private String allocationStatus;
	
	@Column(name = "department_id")
	private int deptId;

	@Column(name = "employee_id")
	private int empId;
	
	@Column(name="auth_manager")
	private String authManager;
	
	// define toString
	@Override
	public String toString() {
		System.out.println("Authorizing Manager -- "+getAuthManager());
		
		return "Inventory [getInv()=" + getInv() + ", getNameOfAsset()=" + getNameOfAsset() + ", getEmployeeId="
				+ getEmpId() + ", getDeptID()=" + getDeptId() + ", getAllocationStatus()=" + getAllocationStatus() + 
				", AuthorizingManager()=" + getAuthManager()+"]";
	}

}