package com.revature.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
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
		
		
		HttpSession session = req.getSession();
		int emp= (int) session.getAttribute("activeemp");
		Employee empObj = eServ.getSessionEmp(emp);
		req.getParameter("firstName");
		req.getParameter("firstName");
		req.getParameter("lastName");
		req.getParameter("department");
		String supervisor = req.getParameter("supervisor");
		Integer supervisorID = Integer.valueOf(supervisor);
		String eventName = req.getParameter("eventName");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String location = req.getParameter("location");
		req.getParameter("workTimeMissed");
		String description = req.getParameter("description");
		String cost = req.getParameter("cost");
		Double costAmt = Double.valueOf(cost);
		String gradingFormat = req.getParameter("gradingFormat");
		String typeOfEvent = req.getParameter("typeOfEvent");
		String justification = req.getParameter("justification");
		String attachmentEvent = req.getParameter("attachmentEvent");
		String attachmentEmail = req.getParameter("attachmentEmail");
		String approval = req.getParameter("approval");
		Integer approvalID = Integer.valueOf(approval);
		
		boolean exceedsFunds;
		if(empObj.getAvailableR()>costAmt) {
			exceedsFunds = false;
		} else {
			exceedsFunds = true;
		}
		UploadFormController.uploadForms(req);
		
		Reimbursement form = new Reimbursement(empObj.getEmpID(),eventName, date,time,location,description,costAmt,attachmentEvent,gradingFormat,typeOfEvent,justification,attachmentEmail,
				supervisorID, approvalID, false, 0, null, exceedsFunds, false, null);
		reDao.submitReimbursement(form);
		
		return "pending.change";
	}
	
	
	public static void getPending(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		List<Reimbursement>forms = new ArrayList<>();
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
