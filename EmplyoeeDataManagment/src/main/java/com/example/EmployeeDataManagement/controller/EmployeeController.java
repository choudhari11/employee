package com.example.EmployeeDataManagement.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.EmployeeDataManagement.model.VWEmployeeData;
import com.example.EmployeeDataManagement.service.EmployeeService;


@Controller
public class EmployeeController {
	
	private static Logger logger = Logger.getLogger("EmployeeController");
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/getEmployeeDetails", method = RequestMethod.POST )
	public ModelAndView getEmployeeDetails(HttpServletRequest request, HttpServletResponse response){
		

		logger.info("START::EmployeeController.getEmployeeDetails");
		try {
			
			String details = employeeService.getAll();
			System.out.println("details"+details);
			
			logger.info("END::EmployeeController.getEmployeeDetails");
			response.getWriter().write(details);

		} catch(Exception exc) {
			logger.error("ERROR::EmployeeController.getEmployeeDetails", exc);
			return null;
		}
		return null;
	}
	
	@RequestMapping(value = "/getEmployeeById", method = RequestMethod.POST )
	public ModelAndView getEmployeeById(HttpServletRequest request,HttpServletResponse response){
		logger.info("START::EmployeeController.getEmployeeById");
	  
		try {
			int deptId = Integer.parseInt(request.getParameter("dept_id"));
			String jsonString = employeeService.getEmployeeDataById(deptId);
			System.out.println("jsonString"+jsonString);
	  
			logger.info("END::EmployeeController.getEmployeeById");
			response.getWriter().write(jsonString);
	  
		} catch(Exception exc) {
			logger.error("ERROR::EmployeeController.getEmployeeById", exc); 
			return null;
		} return null; 
	}
	
	
	 @RequestMapping(value = "/saveEmployeeData", method = RequestMethod.POST)
	    @ResponseBody
	    public ModelAndView saveEmployeeData(HttpServletRequest request, HttpServletResponse response,
	    		@RequestBody VWEmployeeData vwEmployeeData) {
		logger.info("START::EmployeeController.saveEmployeeData");
		String saveStatus = null;
		try {
			saveStatus = employeeService.save(vwEmployeeData);
			System.out.println("saveStatus"+saveStatus);

		    logger.info("END::EmployeeController.saveEmployeeData");
		    response.getWriter().write(saveStatus);

		} catch (Exception exc) {
		    logger.error("ERROR::EmployeeController.saveEmployeeData", exc);
		    return null;
		}
		return null;
	    }
	
	
	

}
