package com.prabathj.orgsrv.fallbackcalls;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.prabathj.orgsrv.dto.AddressResponse;
import com.prabathj.orgsrv.dto.EmployeeInfo;
import com.prabathj.orgsrv.dto.EmployeesList;
import com.prabathj.orgsrv.fiegnclient.EmployeeService;

@Component
public class FiengClientFallBacks implements EmployeeService {

	@Override
	public ResponseEntity<EmployeesList> getAllEmployee() {
		
		EmployeesList def=new EmployeesList();
		List<EmployeeInfo> emp=Arrays.asList(new EmployeeInfo(0, "Dafault", "Dafault", "NA",null),new EmployeeInfo(0, "Dafault1", "Dafault1", "NA1",null));
		def.setAllEmp(emp);
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(def);
	}

}
