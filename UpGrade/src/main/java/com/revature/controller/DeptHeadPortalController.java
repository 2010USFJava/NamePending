package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class DeptHeadPortalController {

	public DeptHeadPortalController() {
		super();
	}
	
	public static String home(HttpServletRequest req) {
		return "HTML/AdminPortal/DeptHeadPortal.html";
	}
}
