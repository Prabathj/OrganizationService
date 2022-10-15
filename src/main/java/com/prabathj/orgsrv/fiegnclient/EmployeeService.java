package com.prabathj.orgsrv.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.prabathj.orgsrv.dto.EmployeesList;
import com.prabathj.orgsrv.fallbackcalls.FiengClientFallBacks;



@FeignClient(name = "employee",url = "http://localhost:9090",path = "/emp-service" )
public interface EmployeeService {

	@GetMapping(path="/employees")
	ResponseEntity<EmployeesList> getAllEmployee();	
}
