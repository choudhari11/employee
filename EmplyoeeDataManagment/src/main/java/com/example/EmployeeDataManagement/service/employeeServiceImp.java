package com.example.EmployeeDataManagement.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeDataManagement.Dao.EmployeeDao;
import com.example.EmployeeDataManagement.model.VWEmployeeData;
import com.google.gson.Gson;
import com.example.EmployeeDataManagement.model.employee;
import com.example.EmployeeDataManagement.model.department;
import com.example.EmployeeDataManagement.model.address;

@Service
public class employeeServiceImp implements EmployeeService{

	private static Logger logger = Logger.getLogger("employeeServiceImp");
    
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public String getAll() {
		// TODO Auto-generated method stub
		logger.info("START::EmployeeServiceImpl.getAll");
		try {
			List<VWEmployeeData> List = employeeDao.getAll();
			String jsonString = new Gson().toJson(List);
			System.out.println("jsonString" + jsonString);
			logger.info("END::EmployeeServiceImpl.getAll");
			return jsonString;

		} catch (Exception exc) {
			logger.error("ERROR::EmployeeServiceImpl.getAll", exc);
			return null;
		}
	}

	@Override
	public String getEmployeeDataById(int deptId) {
		// TODO Auto-generated method stub
		logger.info("START::EmployeeServiceImpl.getEmployeeDataById");
		try {
			List<VWEmployeeData> List = employeeDao.getById(deptId);
			String jsonString = new Gson().toJson(List);
			System.out.println("jsonString" + jsonString);
			logger.info("END::EmployeeServiceImpl.getEmployeeDataById");
			return jsonString;

		} catch (Exception exc) {
			logger.error("ERROR::EmployeeServiceImpl.getEmployeeDataById", exc);
			return null;
		}
	}

	@Override
	public String save(VWEmployeeData vwEmployeeData) {
		// TODO Auto-generated method stub
		try {
		employee emp=new employee();
		department dept=new department();
		address add=new address();
		
		emp.setName(vwEmployeeData.getName());
		emp.setAddress(vwEmployeeData.getAddress());
		emp.setContact(vwEmployeeData.getContact());
		emp.setGender(vwEmployeeData.getGender());
		emp.setDepartentid(vwEmployeeData.getId());
		
		dept.setDepartmentname(vwEmployeeData.getDepartmentname());
		dept.setId(vwEmployeeData.getDeptId());
		
		add.setStreet1(vwEmployeeData.getStreet1());
		add.setStreet2(vwEmployeeData.getStreet2());
		add.setCity(vwEmployeeData.getCity());
		add.setState(vwEmployeeData.getState());
		
		String status=employeeDao.save(emp, dept, add);
		
		if (status.equals("saved")) {
			logger.info("END::EmployeeServiceImpl.save");
			return "saved";
		
		} else {
			logger.info("END::EmployeeServiceImpl.save");
			return "error";
		}

	     }catch (Exception exc) {
		logger.error("ERROR::EmployeeServiceImpl.save", exc);
		return "error";
	
	   }
   }
	
	

}
