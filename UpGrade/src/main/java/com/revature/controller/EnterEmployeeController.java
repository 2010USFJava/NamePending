package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EnterEmployeeController {

	public EnterEmployeeController() {
		super();
	}
	
	public static String home(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session != null) {
			return "HTML/AdminPortal/EnterEmployee.html"; 
		} else {
			return "HTML/Login/AdminLogin.html";
		}
		
	}
}
