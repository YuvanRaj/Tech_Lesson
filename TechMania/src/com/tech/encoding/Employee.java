package com.tech.encoding;

import java.io.Serializable;

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5989424189469249063L;
	
	private int empId;
	private transient String name;

	public Employee(int empId,String name){
		this.empId = empId;
		this.name = name;
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
