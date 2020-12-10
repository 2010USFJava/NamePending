package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.AppLoginController;
import com.revature.controller.BenCoPortalController;
import com.revature.controller.DeptHeadPortalController;
import com.revature.controller.DirectSupervisorPortal;
import com.revature.controller.EmpLoginController;
import com.revature.controller.EmployeeFormController;
import com.revature.controller.EmployeePendingController;
import com.revature.controller.EmployeePortalController;
import com.revature.controller.GradesController;
import com.revature.controller.LogOutController;
import com.revature.controller.PendingReqController;
import com.revature.controller.ReportsController;
import com.revature.controller.RulesController;

public class RequestHelper {

	public static String process(HttpServletRequest req) {
		
		System.out.println(req.getRequestURI());
		switch(req.getRequestURI()) {
		case "/UpGrade/emplogin.change":
			System.out.println("in login.change rhelper");
			return EmpLoginController.login(req);
		case "/UpGrade/emphome.change":
			System.out.println("in home.change rhelper");
			return EmployeePortalController.home(req);
		case "/UpGrade/applogin.change":
			System.out.println("in login.change rhelper");
			return AppLoginController.login(req);
		case "/UpGrade/bencohome.change":
			System.out.println("in benco rhelper");
			return BenCoPortalController.home(req);
		case "/UpGrade/empForm.change":
			System.out.println("in empForm.change");
			return EmployeeFormController.submission(req);
		case "/UpGrade/pending.change":
			System.out.println("in pending.change");
			return EmployeePendingController.pendingPage(req);
		case "/UpGrade/rules.change":
			return RulesController.rules(req);
		case "/UpGrade/depthead.change":
			System.out.println("in depthead rhelper");
			return DeptHeadPortalController.home(req);
		case "/UpGrade/super.change":
			System.out.println("in super rhelper");
			return DirectSupervisorPortal.home(req);
		case "/UpGrade/requests.change":
			System.out.println("in alter helper");
			return PendingReqController.home(req);
		case "/UpGrade/presentations.change":
			System.out.println("in grades helper");
			return GradesController.grades(req);
		case "/UpGrade/deets.change":
			return ReportsController.home(req);
		case "/UpGrade/admin.change":
			System.out.println("in admin.change");
			return EmpLoginController.adminLogin(req);
		case "/UpGrade/logout.change":
			return LogOutController.closeSession(req);
		default:
			System.out.println("in default case");
			return "HTML/unsuccesfullogin.html";
		}
	}

}
