package com.prabathj.orgsrv.dto;

import java.io.Serializable;
import java.util.List;

public class EmployeesList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3480418953897214881L;
	
	private List<EmployeeInfo> allEmp;

	public List<EmployeeInfo> getAllEmp() {
		return allEmp;
	}

	public void setAllEmp(List<EmployeeInfo> allEmp) {
		this.allEmp = allEmp;
	}
	
	

}
