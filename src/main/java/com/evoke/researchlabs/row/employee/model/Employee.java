package com.evoke.researchlabs.row.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * 
 * Employee pojo class
 * @author P A VISHAL
 * @version 1.0
 * 
 */
@Entity
public class Employee {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;
	
	private String userName;
	private String emailId;

	public Employee() {
	}

	public Employee(String userName, String emailId) {
		super();
		this.userName = userName;
		this.emailId = emailId;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [userName=" + userName + " emailId=" + emailId + "]";
	}

	
}
