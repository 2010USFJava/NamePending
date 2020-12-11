package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class IncorrectLoginController {

	public IncorrectLoginController() {
	}
	
	public static String wrongAdmin(HttpServletRequest req) {
		return "HTML/Login/NoSuccessAdmin.html";
	}
	
	public static String wrongEmp(HttpServletRequest req) {
		return "HTML/Login/NoSuccessEmployee.html";
	}
}
