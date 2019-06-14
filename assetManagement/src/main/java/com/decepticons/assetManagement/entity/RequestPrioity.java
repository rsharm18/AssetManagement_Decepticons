package com.decepticons.assetManagement.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="PRIORITY")
public class RequestPrioity {


	@Getter
	@Setter
	//define fields
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "REQPRI_ID_SEQ", allocationSize = 1)
	@Column(name="priority_id")
	private int id;

	@Column(name="priority_status")
	private String requestprioritystatus;
		
	
	//define constructors
	
	public RequestPrioity(int ID,String requestprioritystatus)
	{
		
		this.id = ID;
		this.requestprioritystatus = requestprioritystatus;
	}
	

	
	public RequestPrioity(String requestprioritystatus)
	{
		this.requestprioritystatus = requestprioritystatus;
	}
	

	
	
	//define getter/setters
	
	public RequestPrioity() {
		// TODO Auto-generated constructor stub
	}

	//define toString
	@Override
	public String toString() {
		
		return "Request [getId()=" + getId() + ", getRequestPriory()=" + getRequestprioritystatus() +  "]";
	}
	
	
}
