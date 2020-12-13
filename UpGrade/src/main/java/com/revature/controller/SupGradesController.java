package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SupGradesController {
    public SupGradesController() {
    }

	public static String supgrades(HttpServletRequest req) {
		System.out.println("in Sup Grades Controller");
		HttpSession session = req.getSession(false);
		if(session != null) {
			return "HTML/AdminPortal/SupGrades.html";
		} else {
			return "HTML/Login/EmpLogin.html";
		}
	}

}
