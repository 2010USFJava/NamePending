package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class RulesController {
       
    public RulesController() {
        super();
    }

    public static String rules(HttpServletRequest req) {
    	HttpSession session = req.getSession(false);
    	if(session != null) {
    		return "HTML/EmpPortal/Rules.html";
    	}else {
    		return "HTML/Login/EmpLogin.html";
    	}
	}

}