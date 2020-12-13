package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EmpGradesController{

    public EmpGradesController() {
    }

	public static String grades(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session != null) {
			return "HTML/EmpPortal/GradesPending.html";
		} else {
			return "HTML/Login/EmpLogin.html";
		}
	}

}
