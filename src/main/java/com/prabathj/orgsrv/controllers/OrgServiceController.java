package com.prabathj.orgsrv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prabathj.orgsrv.dto.OrganizationInfo;
import com.prabathj.orgsrv.service.OrgFunctionalServiceInterface;

@RestController
public class OrgServiceController {

	@Autowired
	private OrgFunctionalServiceInterface orgsrv;
	
	
	@GetMapping(path = "/organization")
	public ResponseEntity<OrganizationInfo> getOrganizationInfo(){
		
		OrganizationInfo orgInfo = orgsrv.getOrgInfo();
		return ResponseEntity.ok(orgInfo);
	}
	
}
