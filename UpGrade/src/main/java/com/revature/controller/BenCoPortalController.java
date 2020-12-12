package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BenCoPortalController {

	public BenCoPortalController() {
		super();
	}

	public static String home(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session != null) {
			return "HTML/AdminPortal/BenCoPortal.html";
		} else {
			return "HTML/Login/EmpLogin.html";
		}
	}
}