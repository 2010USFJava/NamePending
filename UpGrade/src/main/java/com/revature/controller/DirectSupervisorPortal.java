package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class DirectSupervisorPortal {

	public DirectSupervisorPortal() {
	}
	public static String home(HttpServletRequest req) {
		return "HTML/AdminPortal/DirSupPortal.html";
	}
}
