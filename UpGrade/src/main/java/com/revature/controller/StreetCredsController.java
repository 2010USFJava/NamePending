package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class StreetCredsController {

	public StreetCredsController() {
	}
	public static String adminCreds(HttpServletRequest req) {
		return "HTML/Login/AdminLogin.html";
	}
	public static String empCreds(HttpServletRequest req) {
		return "HTML/Login/EmpLogin.html";
	}
}
