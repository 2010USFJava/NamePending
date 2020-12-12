package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOutController {
       
    public LogOutController() {
        super();
    }
    
    public static String closeSession(HttpServletRequest req) {
    	HttpSession session = req.getSession();
    		session.invalidate();
    		return EmpLoginController.login(req);
    	
    }
}