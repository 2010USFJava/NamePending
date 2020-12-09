package com.revature.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.ReimbursementDAOImpl;
import com.revature.service.EmployeeService;


public class EmployeeFormController {
	
	public EmployeeFormController() {
		super();
	}
	
	static ReimbursementDAO reDao =new ReimbursementDAOImpl();
	static EmployeeService eServ = new EmployeeService();
	
	public static String submission(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "HTML/EmpPortal/Form.html";
		}
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String department = req.getParameter("department");
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
		Integer approvalType = Integer.valueOf(approval);
		
		Reimbursement form = new Reimbursement(eServ.loginGetEmpID(),eventName, date,time,location,description,costAmt,attachmentEvent,gradingFormat,typeOfEvent,justification,attachmentEmail,
				supervisorID, 1, true, 0, null, false, false, null);
		reDao.submitReimbursement(form);
		
		return "pending.change";
	}
	
	public static void getPending(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		List<Reimbursement> forms = new ArrayList<>();
		forms = reDao.getPendingReimbursement();
		System.out.println("getting pending forms");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, forms);
		byte [] data = out.toByteArray();
		res.getWriter().write("{\"forms\":" + new String(data) + "}");
		System.out.println(new String(data));
	}

}
