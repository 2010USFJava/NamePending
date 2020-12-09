package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ReportsController {

	public ReportsController() {
	}
	
	public static String home(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session !=null) {
			return "HTML/AdminPortal/ViewDeets.html";
		}
		else {
			return "HTML/Login/EmpLogin.html";
		}
	}
}
