package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GradesController {

	public GradesController() {
	}
	
	public static String grades(HttpServletRequest req) {
		System.out.println("in Grades Controller");
		HttpSession session = req.getSession(false);
		if(session != null) {
			return "HTML/AdminPortal/Grades.html";
		} else {
			return "HTML/Login/EmpLogin.html";
		}
	}
}