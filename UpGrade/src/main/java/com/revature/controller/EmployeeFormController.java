package com.revature.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.ReimbursementDAOImpl;
import com.revature.data.Pending;
import com.revature.service.EmployeeService;
import com.revature.utility.logit;


public class EmployeeFormController {
	
	public EmployeeFormController() {
		super();
	}
	
	static ReimbursementDAO reDao =new ReimbursementDAOImpl();
	static EmployeeService eServ = new EmployeeService();
	
	
	public static String submission(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int emp = (int) session.getAttribute("activeemp");
		System.out.println(emp);
		if(!req.getMethod().equals("POST")) {
			return "HTML/EmpPortal/Form.html";
		}
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String department = req.getParameter("department");
		Integer deptheadID = Integer.valueOf(department);
		String supervisor = req.getParameter("supervisor");
		Integer supervisorID = Integer.valueOf(supervisor);
		String eventName = req.getParameter("eventName");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String location = req.getParameter("location");
		String workTimeMissed = req.getParameter("workTimeMissed");
		String description = req.getParameter("description");
		String cost = req.getParameter("cost");
		Double costAmt = Double.valueOf(cost);
		String gradingFormat = req.getParameter("gradingFormat");
		String typeOfEvent = req.getParameter("typeOfEvent");
		String justification = req.getParameter("justification");
		String attachmentEvent = req.getParameter("attachmentEvent");
		String attachmentEmail = req.getParameter("attachmentEmail");
		String approval = req.getParameter("approval");
		if(approval != null) {
		Integer approvalType = Integer.valueOf(approval);
		}
		
		Reimbursement form = new Reimbursement(
				emp,eventName,date,time,location,description,costAmt,attachmentEvent,
				gradingFormat,typeOfEvent,justification,attachmentEmail);
		Employee empObj = new Employee(emp, supervisorID, deptheadID);
		System.out.println("this is the form" + form);
		reDao.submitReimbursement(form, empObj);
		
		return "pending.change";
	}
	
	
	public static void getPending(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		List<Pending> forms = new ArrayList<Pending>();
		forms = reDao.getPendingReimbursement();
		System.out.println(forms);
		System.out.println("getting pending forms");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, forms);
		byte [] data = out.toByteArray();
		System.out.println(new String(data));
		res.getWriter().write(new String(data));
		
	}
	
	public static void getAll(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		HttpSession session = req.getSession();
		int emp = (int) session.getAttribute("activeemp");
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		rList = reDao.getAllReimbursement(emp);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, rList);
		byte [] data = out.toByteArray();
		System.out.println(new String(data));
		res.getWriter().write(new String(data));
	}
	
	public static void getOne(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		String param = req.getParameter("rID");
		Integer rid = Integer.valueOf(param);
		System.out.println("in getOne Employee Form Controller");
		System.out.println(rid);
		Reimbursement rObj = new Reimbursement();
		rObj = reDao.getOneReimbursement(rid);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(new String());
		res.getWriter().write(mapper.writeValueAsString(rObj));
	}
	
	public static void getEvery(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		Reimbursement rObj = new Reimbursement();
		rList = reDao.getEveryReimbursement();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, rList);
		byte [] data = out.toByteArray();
		System.out.println(new String(data));
		res.getWriter().write(new String(data));
	}
	
	public static void getAll(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		HttpSession session = req.getSession();
		int emp = (int) session.getAttribute("activeemp");
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		rList = reDao.getAllReimbursement(emp);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, rList);
		byte [] data = out.toByteArray();
		System.out.println(new String(data));
		res.getWriter().write(new String(data));
	}
	
	public static void getOne(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		String param = req.getParameter("rID");
		Integer rid = Integer.valueOf(param);
		System.out.println("in getOne Employee Form Controller");
		System.out.println(rid);
		Reimbursement rObj = new Reimbursement();
		rObj = reDao.getOneReimbursement(rid);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(new String());
		res.getWriter().write(mapper.writeValueAsString(rObj));
	}
	
	public static void getEvery(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		Reimbursement rObj = new Reimbursement();
		rList = reDao.getEveryReimbursement();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, rList);
		byte [] data = out.toByteArray();
		System.out.println(new String(data));
		res.getWriter().write(new String(data));
	}

}
