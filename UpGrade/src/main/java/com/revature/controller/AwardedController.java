package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AwardedController {

    public AwardedController() {
    }

	public static String awarded(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session != null) {
			return "HTML/EmpPortal/Awarded.html";
		} else {
			return "HTML/Login/EmpLogin.html";
		}
	}

}
