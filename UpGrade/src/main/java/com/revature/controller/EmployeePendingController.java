package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class EmployeePendingController {
	public EmployeePendingController() {
		super();
	}

	public static String pendingPage(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session != null) {
			return "HTML/EmpPortal/Pending.html";
		}else {
			return "HTML/Login/EmpLogin.html";
		}
		 
	}
	

}
