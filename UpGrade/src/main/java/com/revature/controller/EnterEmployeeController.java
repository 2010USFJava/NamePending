package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class EnterEmployeeController {

	public EnterEmployeeController() {
		super();
	}
	
	public static String home(HttpServletRequest req) {
		return "HTML/AdminPortal/EnterEmployee.html";
	}
}
