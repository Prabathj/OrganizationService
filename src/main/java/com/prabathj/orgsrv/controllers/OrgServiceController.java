package com.prabathj.orgsrv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prabathj.orgsrv.dto.OrganizationInfo;
import com.prabathj.orgsrv.service.OrgFunctionalServiceInterface;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class OrgServiceController {

	@Autowired
	private OrgFunctionalServiceInterface orgsrv;
	
	private Logger logger=LoggerFactory.getLogger(OrgServiceController.class);
	
	@CircuitBreaker(name="org-info",fallbackMethod = "getOrganizationInfo_fallback" )
	@GetMapping(path = "/organization")
	public ResponseEntity<OrganizationInfo> getOrganizationInfo(){
		
		OrganizationInfo orgInfo = orgsrv.getOrgInfo();
		System.err.println("/organization");
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
	
	@CircuitBreaker(name="org-info-single",fallbackMethod = "getOrgInfoWithOneEmployeeFallback")
	@GetMapping(path = "/organization/{empid}")
	public ResponseEntity<OrganizationInfo> getOrgInfoWithOneEmployee(@PathVariable int empid){
		
		OrganizationInfo orgInfoWithOneEmppyee = orgsrv.getOrgInfoWithOneEmppyee(empid);
		System.err.println("/orgnization/{empid}");
		if(empid==2)	//At this point also fall back method will be called, fall back is relevant to the whole methods fails
			throw new NullPointerException("We throw NULL POINTER"); 
		
		return ResponseEntity.ok(orgInfoWithOneEmppyee);
	}
	
	public ResponseEntity<OrganizationInfo> getOrgInfoWithOneEmployeeFallback( int empid,Throwable ex){
		
		System.err.println("Inside FallBack Emp "+ ex.getMessage());
		OrganizationInfo obj=new OrganizationInfo();
		obj.setName("Fall Back- SLTMobitel");
		obj.setRegid("Fallback HR-REG-CC832");
		obj.setEmployees(null);
		return ResponseEntity.ok(obj);		
	}
	
	@Retry(name = "org-info-retry",fallbackMethod = "usingRetryPatternFallback")
	@GetMapping(path = "/org-info-retry/{empid}",params = {"retry"})
	public ResponseEntity<OrganizationInfo> usingRetryPattern(@PathVariable int empid){
		if(empid==1)	//At this point also fall back method will be called, fall back is relevant to the whole methods fails
			throw new NullPointerException("We throw NULL POINTER Retry1"); 
		System.err.println("/org-info-retry/{empid}");
		OrganizationInfo orgInfoWithOneEmppyee = orgsrv.getOrgInfoWithOneEmppyee(empid);
		
		logger.info("/org-info-retry/{empid}");
		if(empid==2)	//At this point also fall back method will be called, fall back is relevant to the whole methods fails
			throw new NullPointerException("We throw NULL POINTER Retry"); 
		
		return ResponseEntity.ok(orgInfoWithOneEmppyee);		
	}
	
	public ResponseEntity<OrganizationInfo> usingRetryPatternFallback( int empid,Throwable ex){
		
		System.err.println("Inside FallBack Emp "+ ex.getClass().toString());
		OrganizationInfo obj=new OrganizationInfo();
		obj.setName("Fall Back- SLTMobitel");
		obj.setRegid("Fallback HR-REG-CC832");
		obj.setEmployees(null);
		return ResponseEntity.ok(obj);		
	}
		
	
	@GetMapping(path="/orgaization/{empname}")
	@CircuitBreaker(name = "org-info-name")
	public ResponseEntity<OrganizationInfo> orgInfoWithOnlyName(@PathVariable String empname){
		
		OrganizationInfo obj = orgsrv.getOrgInfoWithEmppyeeName(empname);
		return ResponseEntity.ok(obj);
	}
	
}
