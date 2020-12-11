package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class ReportsController {

	public ReportsController() {
	}
	
	public static String home(HttpServletRequest req) {
		return "HTML/AdminPortal/ViewDeets.html";
	}
}
