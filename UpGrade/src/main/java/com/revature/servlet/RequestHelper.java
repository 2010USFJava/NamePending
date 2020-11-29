package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.EmpLoginController;
import com.revature.controller.EmployeePortalController;

public class RequestHelper {

	public static String process(HttpServletRequest req) {
		
		System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/UpGrade/login.change":
			System.out.println("in login.change rhelper");
			return EmpLoginController.login(req);
		case "/UpGrade/home.change":
			System.out.println("in home.change rhelper");
			return EmployeePortalController.home(req);
		default:
			System.out.println("in default case");
			return "HTML/unsuccesfullogin.html";
		}
	}

}
