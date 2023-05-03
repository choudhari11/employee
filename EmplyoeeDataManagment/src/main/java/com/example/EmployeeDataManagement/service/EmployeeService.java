package com.example.EmployeeDataManagement.service;

import com.example.EmployeeDataManagement.model.VWEmployeeData;

public interface EmployeeService {
	
	String getAll();
	
	String getEmployeeDataById(int deptId);
	
	String save(VWEmployeeData vwEmployeeData);


}
