package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.service.EmployeeService;
import com.revature.utility.ConnFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	public static ConnFactory cf=ConnFactory.getInstance();
	EmployeeDAO empDao = new EmployeeDAOImpl();
	EmployeeService eServ = new EmployeeService();
	
	static { 
		try {
			Class.forName("org.postgresql.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void submitReimbursement(Reimbursement form) {
		try {
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO reimbursements VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, form.getEmpID());
			ps.setString(2, form.getEventName());
			//ps.setString(3, form.getEventDate());
			ps.setDate(3, form.getEventDate());
			ps.setString(4, form.getEventTime());
			ps.setString(5, form.getEventLocation());
			ps.setString(6, form.getEventLocation());
			ps.setString(7, form.getEventLocation());
			ps.setString(8, form.getDescription());
			ps.setDouble(9, form.getEventCost());
			ps.setString(10, form.getEventFile());
			ps.setString(11, form.getGradingFormat());
			ps.setString(12, form.getEventType());
			ps.setString(13, form.getJustification());
			ps.setString(14, form.getApprovalFile());
			ps.setInt(13, form.getDsApprove());
			ps.setInt(15, form.getDhApprove());
			ps.setBoolean(16, form.isBcApprove());
			ps.setInt(16, form.getAlteredAmount());
			ps.setString(17, form.getAlteredReason());
			ps.setBoolean(18, form.isExceedingFunds());
			ps.setBoolean(19, form.isAwarded());
			ps.setString(20, form.getDenialReason());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
