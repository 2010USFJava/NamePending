package com.revature.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.controller.EmpLoginController;
import com.revature.controller.EmployeeController;
import com.revature.controller.EmployeeFormController;
import com.revature.controller.LogOutController;

public class JSONRequestHelper{
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		switch(req.getRequestURI()) {
		case "/UpGrade/getsession.json":
			System.out.println("in request helper");
			EmployeeController.getSessionEmp(req, res);
			break;
		case "/UpGrade/getPending.json":
			System.out.println("in pending request helper");
			EmployeeFormController.getPending(req, res);
			break;
		case "/UpGrade/logout.json":
			LogOutController.closeSession(req, res);
			break;
		default:
			System.out.println("Not twerking");
			EmployeeController.getSessionEmp(req, res);
		}
		
	}
}
