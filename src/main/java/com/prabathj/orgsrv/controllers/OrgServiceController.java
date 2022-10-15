package com.prabathj.orgsrv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prabathj.orgsrv.dto.OrganizationInfo;
import com.prabathj.orgsrv.service.OrgFunctionalServiceInterface;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class OrgServiceController {

	@Autowired
	private OrgFunctionalServiceInterface orgsrv;
	
	@CircuitBreaker(name="org-info",fallbackMethod = "getOrganizationInfo_fallback" )
	@GetMapping(path = "/organization")
	public ResponseEntity<OrganizationInfo> getOrganizationInfo(){
		
		OrganizationInfo orgInfo = orgsrv.getOrgInfo();
		return ResponseEntity.ok(orgInfo);
	}
	
	public ResponseEntity<OrganizationInfo> getOrganizationInfo_fallback(Throwable exceptions){
		System.err.println("Inside FallBack");
		OrganizationInfo obj=new OrganizationInfo();
		obj.setName("Fall Back- Mobitel");
		obj.setRegid("Fallback IT-REG-48240");
		obj.setEmployees(null);
		return ResponseEntity.ok(obj);
	}	
	
}
