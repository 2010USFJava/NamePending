package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class GradesController {

	public GradesController() {
	}
	
	public static String home(HttpServletRequest req) {
		return "HTML/AdminPortal/Grades.html";
	}
}
