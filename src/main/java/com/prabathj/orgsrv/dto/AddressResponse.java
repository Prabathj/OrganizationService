package com.prabathj.orgsrv.dto;

public class AddressResponse {
	
	private Integer adressid;
	private String lane1;
	private String lane2;
	private String state;
	private Integer zipcode;
	
	public Integer getAdressid() {
		return adressid;
	}
	public void setAdressid(Integer adressid) {
		this.adressid = adressid;
	}
	public String getLane1() {
		return lane1;
	}
	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}
	public String getLane2() {
		return lane2;
	}
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	
	

}
