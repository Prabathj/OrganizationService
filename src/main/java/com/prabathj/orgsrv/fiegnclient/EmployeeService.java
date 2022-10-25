package com.prabathj.orgsrv.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import com.prabathj.orgsrv.dto.EmployeeInfo;
import com.prabathj.orgsrv.dto.EmployeesList;
import com.prabathj.orgsrv.fallbackcalls.FiengClientFallBacks;



@FeignClient(name = "employee",path="/emp-service")
public interface EmployeeService {

	@GetMapping(path="/employees")
	ResponseEntity<EmployeesList> getAllEmployee();	
	
	@GetMapping(path = "/employees/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<EmployeeInfo> getEmployeeById(@PathVariable(name = "id") int employeeId);
	
	@GetMapping(path="/employees/{emp_name}")
	public ResponseEntity<EmployeeInfo> employeeWithName(@PathVariable("emp_name") String empName);	
	
}
