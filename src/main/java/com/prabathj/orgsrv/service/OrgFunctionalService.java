package com.prabathj.orgsrv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prabathj.orgsrv.dto.EmployeesList;
import com.prabathj.orgsrv.dto.OrganizationInfo;
import com.prabathj.orgsrv.fiegnclient.EmployeeService;
@Service
public class OrgFunctionalService implements OrgFunctionalServiceInterface{

	@Autowired
	private EmployeeService empSrv;
	
	
	@Override
	public OrganizationInfo getOrgInfo() {
		System.err.println("Inside Service");
		OrganizationInfo obj=new OrganizationInfo();
		
		ResponseEntity<EmployeesList> allEmployee = empSrv.getAllEmployee();
		
		EmployeesList body = allEmployee.getBody();
		obj.setEmployees(body.getAllEmp());
		
		return obj;
	}

}
