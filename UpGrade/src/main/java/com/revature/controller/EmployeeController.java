package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.beans.Employee;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.beans.Employee;

public class EmployeeController {
	public static Employee getSessionEmp(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		HttpSession session = req.getSession();
		Employee emp= (Employee) session.getAttribute("activeemp");
		System.out.println("in employee controller");
		System.out.println(emp);
		return emp;
		//res.getWriter().write(new ObjectMapper().writeValueAsString(emp));
	}
}
