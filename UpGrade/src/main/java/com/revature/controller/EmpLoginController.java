package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.Employee;
import com.revature.service.EmployeeService;

public class EmpLoginController {
	static EmployeeService eServ = new EmployeeService();
	
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "HTML/Login/EmpLogin.html";
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Employee emp = eServ.loginGetEmp(username, password);
		if(emp==null) {
			return "wrongcreds.change";
		} else {
			req.getSession().setAttribute("activeemp", emp);
			return "emphome.change";
		}
	}
}
