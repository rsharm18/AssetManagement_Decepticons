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
	
	//define constructors
	
	public Employee()
	{
		
	}
	
	public Employee(int ID, String first_name, String last_name, String email) {
		super();
		this.firstname = first_name;
		this.lastname = last_name;
		this.email = email;
		this.id = ID;
	}
	
	public Employee(String first_name, String last_name, String email) {
		super();
		this.firstname = first_name;
		this.lastname = last_name;
		this.email = email;
	}
	//define getter/setters
	
	//define toString
	@Override
	public String toString() {
		return "Employee [getId()=" + getId() + ", getFirst_name()=" + getFirstname() + ", getLast_name()="
				+ getLastname() + ", getEmail()=" + getEmail() + "]";
	}
	
	
}
