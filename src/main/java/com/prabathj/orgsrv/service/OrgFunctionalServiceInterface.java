package com.prabathj.orgsrv.service;

import com.prabathj.orgsrv.dto.OrganizationInfo;

public interface OrgFunctionalServiceInterface {

	OrganizationInfo getOrgInfo();
	OrganizationInfo getOrgInfoWithOneEmppyee(int empid);
	OrganizationInfo getOrgInfoWithEmppyeeName(String empname);
	
}
