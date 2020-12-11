package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.Approver;
import com.revature.service.ApproverService;

public class AppLoginController {
	static ApproverService aServ = new ApproverService();
	
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "HTML/Login/AdminLogin.html";
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Approver app = aServ.loginGetApp(username, password);
		if(app==null) {
			return "wrongcreds.change";
		} else {
			req.getSession().setAttribute("activeapp", app.getApproverID());
			switch(app.getRole()) {
			case "benco":
				System.out.println("in benco");
				return "bencohome.change";
			case "depthead":
				System.out.println("in dept head");
				return "depthead.change";
			case "supervisor":
				System.out.println("in super");
				return "super.change";
			default:
				return "what";
			}
		}
		
	}
}
