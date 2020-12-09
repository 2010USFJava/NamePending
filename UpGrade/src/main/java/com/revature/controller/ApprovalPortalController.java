package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApprovalPortalController {

	public ApprovalPortalController() {
		super();
	}
	
	public static String home(HttpServletRequest req) {
		return "HTML/AdminPortal/BenCoPortal.html";
	}
	
	public static void getPendingFroms(HttpServletRequest req, HttpServletResponse res) {
		
	}
}
