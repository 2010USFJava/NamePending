package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Approver;
import com.revature.service.ApproverService;

public class BenCoPortalController {
	static ApproverService aServ = new ApproverService();
	
	public static void getSession(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		HttpSession session = req.getSession();
		int app = (int) session.getAttribute("activeapp");
		Approver appObj = aServ.getSessionApp(app);
		ObjectMapper mapper = new ObjectMapper();
		String appString = mapper.writeValueAsString(appObj);
		res.getWriter().write(appString);
	}
}
