package com.revature.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.daoimpl.EmployeeDAOImpl;

public class EmployeeInsertController {

	static EmployeeDAO eDao = new EmployeeDAOImpl();
	
	public static String insertEmployee(HttpServletRequest req) throws ServletException{
		
		HttpSession session = req.getSession();
		session.getAttribute("activeapp");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String supervisor = req.getParameter("supervisor");
		Integer supervisorID = Integer.parseInt(supervisor);
		String deptHead = req.getParameter("depthead");
		Integer deptHeadID = Integer.parseInt(deptHead);
		Employee emp = new Employee(firstName,lastName,userName,password,1000,supervisorID,deptHeadID);
		System.out.println(emp.toString());
		eDao.insertEmployee(emp);
		return "depthead.change";
		
	}

}
