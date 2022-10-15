package com.prabathj.orgsrv.dto;

public class EmployeeInfo {

	private Integer employeeid;
	private String employeename;
	private String email;
	private String bloodgroup;
	private AddressResponse addressRsp;
	
	
	
	public EmployeeInfo(Integer employeeid, String employeename, String email, String bloodgroup,
			AddressResponse addressRsp) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.email = email;
		this.bloodgroup = bloodgroup;
		this.addressRsp = addressRsp;
	}
	
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public AddressResponse getAddressRsp() {
		return addressRsp;
	}
	public void setAddressRsp(AddressResponse addressRsp) {
		this.addressRsp = addressRsp;
	}
	
	
}
