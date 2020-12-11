package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DetailsController {
       
    public DetailsController() {
    }

    public static String details(HttpServletRequest req) {
		System.out.println("in Details Controller");
		HttpSession session = req.getSession(false);
		if(session != null) {
			return "HTML/AdminPortal/Details.html";
		} else {
			return "HTML/Login/EmpLogin.html";
		}
	}

}
