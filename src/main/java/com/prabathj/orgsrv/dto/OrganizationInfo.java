package com.prabathj.orgsrv.dto;

import java.util.List;

public class OrganizationInfo {
	
	private String name="Mobitel";
	private String regid="IT-REG-48240";
	
	private List<EmployeeInfo> employees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

	public List<EmployeeInfo> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeInfo> employees) {
		this.employees = employees;
	}
	
	

}
