package com.prabathj.orgsrv.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.prabathj.orgsrv.controllers.OrgServiceController;
import com.prabathj.orgsrv.dto.EmployeeInfo;
import com.prabathj.orgsrv.dto.EmployeesList;
import com.prabathj.orgsrv.dto.OrganizationInfo;
import com.prabathj.orgsrv.fiegnclient.EmployeeService;
@Service
public class OrgFunctionalService implements OrgFunctionalServiceInterface{

	@Autowired
	private EmployeeService empSrv;
	
	private Logger logger=LoggerFactory.getLogger(OrgFunctionalService.class);
	
	@Override
	public OrganizationInfo getOrgInfo() {
		System.err.println("Inside Service");
		OrganizationInfo obj=new OrganizationInfo();
		
		ResponseEntity<EmployeesList> allEmployee = empSrv.getAllEmployee();
		
		EmployeesList body = allEmployee.getBody();
		obj.setEmployees(body.getAllEmp());
		
		return obj;
	}


	@Override
	public OrganizationInfo getOrgInfoWithOneEmppyee(int empid) {
		
		System.err.println("Inside Service EMPID");
		logger.info("Inside Service EMPID");
		OrganizationInfo obj=new OrganizationInfo();
		
		ResponseEntity<EmployeeInfo> employeeById = empSrv.getEmployeeById(empid);
		
		List<EmployeeInfo> empList=new ArrayList<>();
		empList.add(employeeById.getBody());
		obj.setEmployees(empList);
		
		
		return obj;
	}


	@Override
	public OrganizationInfo getOrgInfoWithEmppyeeName(String empname) {
		
		OrganizationInfo obj=new OrganizationInfo();
		
		ResponseEntity<EmployeeInfo> employeeWithName = empSrv.employeeWithName(empname);
		EmployeeInfo body = employeeWithName.getBody();
		
		obj.setEmployees(Arrays.asList(body));
		return obj;
	}

}
