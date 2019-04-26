package com.decepticons.assetManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="employee")
public class Employee {


	@Getter
	@Setter
	//define fields
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "EMP_ID_SEQ", allocationSize = 1)
	@Column(name="employee_id")
	private int id;

	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email")
	private String email;

	@Column(name = "end_date")
	//@DateTimeFormat(pattern = "dd/mm/YY")
	private Date endDate;

	@Column(name = "hire_date")
	private Date hireDate;

	@Column(name = "phone_number")
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	private int salary;

	// bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department department;

	
	@Column(name = "user_Name")
	private String userName;
	
//	@Column(name = "password")
//	private String password;
	
	//define toString
	@Override
	public String toString() {
		return "Employee [getId()=" + getId() + ", getFirst_name()=" + getFirstname() + ", getLast_name()="
				+ getLastname() + ", getEmail()=" + getEmail() + "]";
	}
	
	
}
