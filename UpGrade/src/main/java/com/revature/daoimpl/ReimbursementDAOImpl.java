package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			String sql = "INSERT INTO reimbursements VALUES (DEFAULT,?,?,TO_DATE(?,'YYYY-MM-DD'),TO_TIMESTAMP(?,'HH12:MI:SS'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, form.getEmpID());
			ps.setString(2, form.getEventName());
			ps.setString(3, form.getDate());
			ps.setString(4, form.getTime());
			ps.setString(5, form.getLocation());
			ps.setString(6, form.getDescription());
			ps.setDouble(7, form.getCost());
			ps.setString(8, "Attachments/"+form.getEventFile());
			ps.setString(9, form.getGradingFormat());
			ps.setString(10, form.getEventType());
			ps.setString(11, form.getJustification());
			ps.setString(12, "Attachments/"+form.getApprovalFile());
			ps.setInt(13, form.getDsApproval());
			ps.setInt(14, form.getDhApproval());
			ps.setBoolean(15, form.isBcApproval());
			ps.setDouble(16, form.getAlteredAmt());
			ps.setString(17, form.getAlteredReason());
			ps.setBoolean(18, form.isExceedingFunds());
			ps.setBoolean(19, form.isAwarded());
			ps.setString(20, form.getDenialReason());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> getPendingReimbursement() {
		List<Reimbursement> forms = new ArrayList<Reimbursement>();
		PreparedStatement ps;
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM reimbursements WHERE bc_approve=false";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				forms.add(new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getInt(14),rs.getInt(15),rs.getBoolean(16),rs.getInt(17),rs.getString(18),rs.getBoolean(19),rs.getBoolean(20),rs.getString(21)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return forms;
	}
	
	
}
