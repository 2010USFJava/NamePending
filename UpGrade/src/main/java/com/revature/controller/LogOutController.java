package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutController {
       
    public LogOutController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static String closeSession(HttpServletRequest req, HttpServletResponse res) {
    	HttpSession session = req.getSession();
    	session.invalidate();
    	return EmpLoginController.login(req);
    }


}
