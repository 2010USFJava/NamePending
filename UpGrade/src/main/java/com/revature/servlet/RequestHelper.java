package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.revature.controller.AppLoginController;
import com.revature.controller.BenCoPortalController;
import com.revature.controller.DeptHeadPortalController;
import com.revature.controller.DetailsController;
import com.revature.controller.DirectSupervisorPortal;
import com.revature.controller.EmpLoginController;
import com.revature.controller.EmployeeFormController;
import com.revature.controller.EmployeeInsertController;
import com.revature.controller.EmployeePendingController;
import com.revature.controller.EmployeePortalController;
import com.revature.controller.EnterEmployeeController;
import com.revature.controller.GradesController;
import com.revature.controller.IncorrectLoginController;
import com.revature.controller.LogOutController;
import com.revature.controller.PendingReqController;
import com.revature.controller.ReportsController;
import com.revature.controller.RulesController;
import com.revature.controller.SingleViewController;
import com.revature.controller.StreetCredsController;

public class RequestHelper {

	public static String process(HttpServletRequest req) throws IOException, ServletException {
		
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
			return GradesController.grades(req);
		case "/UpGrade/deets.change":
			return ReportsController.home(req);
		case "/UpGrade/wrongcredsAdmin.change":
			return IncorrectLoginController.wrongAdmin(req);
		case "/UpGrade/wrongcredsEmp.change":
			return IncorrectLoginController.wrongEmp(req);
		case "/UpGrade/adminCredCheck.change":
			return StreetCredsController.adminCreds(req);
		case "/UpGrade/empCredCheck.change":
			return StreetCredsController.empCreds(req);
		case "/UpGrade/upload.change":
			System.out.println("in upload change?");
		case "/UpGrade/enterEmployee.change":
			return EnterEmployeeController.home(req);
		case "/UpGrade/insertEmployee.change":
			return EmployeeInsertController.insertEmployee(req);
		case "/UpGrade/details.change":
			return DetailsController.details(req);
		case "/UpGrade/reports.change":
			System.out.println("in request helper");
			return ReportsController.home(req);
		case "/UpGrade/logout.change":
			return LogOutController.closeSession(req);
		case "/UpGrade/viewsingle.change":
			return SingleViewController.single(req);
		case "/UpGrade/admin.change":
			System.out.println("in admin.change");
			return EmpLoginController.adminLogin(req);
		default:
			System.out.println("in default case");
			System.out.println(req.getRequestURI());
			return "HTML/unsuccesfullogin.html";
		}
	}

}
