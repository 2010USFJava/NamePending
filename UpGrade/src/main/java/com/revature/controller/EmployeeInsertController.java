package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.beans.Approver;
import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.service.ApproverService;
import com.revature.utility.logit;

public class EmployeeInsertController {

	static EmployeeDAO eDao = new EmployeeDAOImpl();
	static ApproverService aServ = new ApproverService();
	
	public static String insertEmployee(HttpServletRequest req) throws ServletException{
		if(!req.getMethod().equals("POST")) {
			return "HTML/AdminPortal/EnterEmployee.html";
		}
		HttpSession session = req.getSession();
		int app = (int)session.getAttribute("activeapp");
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
		Approver appObj = aServ.getSessionApp(app);
		
		try {
			logit.LogIt("info", appObj.getUserName() + " has entered " + emp.getFirstName() + " as a new employee");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "depthead.change";
		
	}

}
