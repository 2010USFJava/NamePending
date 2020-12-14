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
import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.daoimpl.ReimbursementDAOImpl;
import com.revature.data.Pending;

public class DsDhController {

    public DsDhController() {
    }
    
    static ReimbursementDAO reDao =new ReimbursementDAOImpl();

    public static void getDSPending(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
    	List<Pending> forms = new ArrayList<Pending>();
		forms = reDao.getDSReimbursement();
		System.out.println(forms);
		System.out.println("getting pending forms");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, forms);
		byte [] data = out.toByteArray();
		System.out.println(new String(data));
		res.getWriter().write(new String(data));
    }

    public static void getDHPending(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
    	List<Pending> forms = new ArrayList<Pending>();
		forms = reDao.getDHReimbursement();
		System.out.println(forms);
		System.out.println("getting pending forms");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, forms);
		byte [] data = out.toByteArray();
		System.out.println(new String(data));
		res.getWriter().write(new String(data));
    }
    
    public static void getGrades(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
    	List<Reimbursement> rList = new ArrayList<Reimbursement>();
    	HttpSession session = req.getSession();
		int emp = (int) session.getAttribute("activeemp");
    	rList = reDao.getPendingGrades(emp);
    	ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, rList);
		byte [] data = out.toByteArray();
		System.out.println(new String(data));
		res.getWriter().write(new String(data));
    }
}
