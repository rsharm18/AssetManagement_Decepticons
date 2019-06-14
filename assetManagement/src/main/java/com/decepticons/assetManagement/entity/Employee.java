package com.decepticons.assetManagement.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee implements Serializable{

	public static Set<String> skipMethodsListFromPersist = new HashSet<String>();

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "EMP_ID_SEQ", allocationSize = 1)
	@Column(name = "employee_id")
	private int id;

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "end_date")
	// @DateTimeFormat(pattern = "dd/mm/YY")
	private Date endDate;

	@Column(name = "hire_date")
	private Date hireDate;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "gender")
	private String gender;

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


	@Column(name = "ssn_no")
	private String sSNInfo;

	@OneToOne
	@JoinColumn(name = "reporting_manager")
	private Employee manager;

	// define toString

	@Override
	public String toString() {
		System.out.println("Manager -- " + getManager() + " null ? " + (getManager() != null));
		System.out.println("Mgr info" + (getManager() != null ? getManager().getId() + " - " + getManager().getName() : "-NA"));

		return "Employee [getId()=" + getId() + ", getFirst_name()=" + getFirstname() + ", getLast_name()=" + getLastname() + ", getEmail()=" + getEmail() + ", getDept()=" + getDepartment()
				+ ", manager()=" + getManagerName() + "]";
	}

	public String getName() {
		return firstname + " " + lastname;
	}

	public String getManagerName() {
		return (getManager() != null ? getManager().getName() : "-NA");
	}

	public String getSSNLast4Digits() {
		String temp = this.getSSNInfo();
		if (temp != null && temp.trim().length() > 4) {
			return "***-**-" + temp.substring(temp.trim().length() - 4);
		}

		return "-NA-";
	}

	static {
		skipMethodsListFromPersist.add("getName");
		skipMethodsListFromPersist.add("getManagerName");
		skipMethodsListFromPersist.add("getId");
		skipMethodsListFromPersist.add("getClass");
		skipMethodsListFromPersist.add("getSSNLast4Digits");
//		skipMethodsListFromPersist.add("getLastLoginDate");
//		skipMethodsListFromPersist.add("setLastLoginDate");

	}

}
