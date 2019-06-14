package com.decepticons.assetManagement.entity;

import java.sql.Date;

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
@Table(name = "LOGIN_HISTORY")

public class LoginHistory {

	@Getter
	@Setter

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "LOGINHISTORY_ID_SEQ", allocationSize = 1)
	@Column(name = "loginhistory_id")
	private int id;

	@Column(name = "USERID")
	String username;

	@Column(name = "LOGINTIME")
	Date lastlogin;

}
