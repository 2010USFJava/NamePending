package com.revature.controller;

import javax.servlet.http.HttpServletRequest;


public class RulesController {
       
    public RulesController() {
        super();
    }

    public static String rules(HttpServletRequest req) {
		return "HTML/EmpPortal/Rules.html";
	}

}
