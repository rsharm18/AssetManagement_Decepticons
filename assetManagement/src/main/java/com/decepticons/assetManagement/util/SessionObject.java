package com.decepticons.assetManagement.util;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.context.annotation.Scope;

import com.decepticons.assetManagement.entity.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Scope("session")
public class SessionObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Employee user;
	Date lastLogin;

	public SessionObject() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SessionObject : " + getLastLogin() + " :: " + getUser();
	}

}
