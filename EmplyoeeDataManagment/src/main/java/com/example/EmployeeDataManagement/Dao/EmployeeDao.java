package com.example.EmployeeDataManagement.Dao;

import java.util.List;

import com.example.EmployeeDataManagement.model.VWEmployeeData;
import com.example.EmployeeDataManagement.model.address;
import com.example.EmployeeDataManagement.model.department;
import com.example.EmployeeDataManagement.model.employee;



public interface EmployeeDao {
	
	
	List<VWEmployeeData> getAll();
	
	List<VWEmployeeData> getById(int deptId);
	
	String save(employee Employee,department dept,address Address);

}
