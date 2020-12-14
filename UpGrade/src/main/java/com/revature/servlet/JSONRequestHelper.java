package com.revature.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.controller.DsDhController;
import com.revature.controller.EmployeeController;
import com.revature.controller.EmployeeFormController;

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
		case "/UpGrade/getAll.json":
			System.out.println("in getAll request helper");
			EmployeeFormController.getAll(req, res);
			break;
		case "/UpGrade/getEmpDetails.json":
			EmployeeFormController.getOne(req, res);
			break;
		case "/UpGrade/getDSPending.json":
			DsDhController.getDSPending(req, res);
			break;
		case "/UpGrade/getDHPending.json":
			DsDhController.getDHPending(req, res);
			break;
		case "/UpGrade/getEvery.json":
			EmployeeFormController.getEvery(req, res);
			break;
		case "/UpGrade/getGrades.json":
			DsDhController.getGrades(req, res);
			break;
		default:
			System.out.println("Not twerking");
			EmployeeController.getSessionEmp(req, res);
		}
		
	}
}
