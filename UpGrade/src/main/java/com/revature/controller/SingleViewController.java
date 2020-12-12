package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SingleViewController {
    public SingleViewController() {
    }

    public static String single(HttpServletRequest req) {
		System.out.println("in Single View Controller");
		HttpSession session = req.getSession(false);
		if(session != null) {
			return "HTML/EmpPortal/SingleView.html";
		} else {
			return "HTML/Login/EmpLogin.html";
		}
	}
    
    public static String response(HttpServletRequest req, HttpServletResponse res) {
    	System.out.println("in Single View Controller");
		HttpSession session = req.getSession(false);
		if(session != null) {
			return "HTML/EmpPortal/SingleView.html";
		} else {
			return "HTML/Login/EmpLogin.html";
		}
    }
}
