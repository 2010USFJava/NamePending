package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.ReimbursementDAOImpl;

public class BenCoPortalController {

	public BenCoPortalController() {
		super();
	}
	
	static ReimbursementDAO reDao = new ReimbursementDAOImpl();

	public static String home(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session != null) {
			return "HTML/AdminPortal/BenCoPortal.html";
		} else {
			return "HTML/Login/EmpLogin.html";
		}
	}
	
	public static String approve(HttpServletRequest req) throws IOException {
		String approve = req.getParameter("rIDapprove");
		Integer approveForm = Integer.parseInt(approve);
		Reimbursement form = new Reimbursement();
		form = reDao.getOneReimbursement(approveForm);
		reDao.reimbursementApproved(form);
		return "bencohome.change";
	}
	
	public static String deny(HttpServletRequest req) throws IOException {
		String deny = req.getParameter("rIDdeny");
		Integer denyForm = Integer.parseInt(deny);
		Reimbursement form = new Reimbursement();
		form = reDao.getOneReimbursement(denyForm);
		reDao.reimbursementDenied(form);
		return "bencohome.change";
	}
}