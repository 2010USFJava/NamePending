package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;

public class EmployeeController {
	public static void getSessionEmp(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		Employee emp= (Employee) req.getSession().getAttribute("activeemp");
		res.getWriter().write(new ObjectMapper().writeValueAsString(emp));
	}
}
