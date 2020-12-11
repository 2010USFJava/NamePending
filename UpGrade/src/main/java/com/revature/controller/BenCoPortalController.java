package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class BenCoPortalController {

	public BenCoPortalController() {
		super();
	}

	public static String home(HttpServletRequest req) {
		return "HTML/AdminPortal/BenCoPortal.html";
	}
}
