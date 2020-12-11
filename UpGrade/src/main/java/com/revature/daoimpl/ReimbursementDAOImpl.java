package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.service.EmployeeService;
import com.revature.utility.ConnFactory;
import com.revature.utility.Stmnt;
import com.revature.utility.logit;

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
			logit.LogIt("info", "Reimbursement: "+form.getR_ID()+" for Employee ID: "+form.getEmpID()+" was submitted.");
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
			System.out.println("Check getPendingReimbursement SQL " + e.getSQLState() + " " + e.getMessage());
		}
		return forms;
	}
	
	//search reimbursements by ID
	public Reimbursement getReimbursementByID(int id) {
		String sql ="SELECT * FROM reimbursements WHERE rid =? ";
		Reimbursement r = null;
		try {
			PreparedStatement ps = Stmnt.makePrStmnt(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs !=null) {
			    rs.equals(r);
			    return r;
			}
			
		}
		catch (SQLException e) {
			System.out.println("Check getReimbursementByID SQL " + e.getSQLState() + " " + e.getMessage());
		}
		
		return null;
	}
	
	// update reimbursement to approved
	public void  reimbursementApproved(Reimbursement r) {
		int id = r.getR_ID();
		String sql ="UPDATE reimbursements SET bc_approve = true  where rid = ? ";
		
			try {
				PreparedStatement ps = Stmnt.makePrStmnt(sql);
				ps.setInt(1, id);
				ps.executeUpdate();
				logit.LogIt("info", "Reimbursement: "+id+" for Employee ID: "+r.getEmpID()+" Was Approved");
			}
		catch (SQLException e) {
			System.out.println("Check reimbursementApproved SQL " + e.getSQLState() + " " + e.getMessage());
		}
	}
	
	//update reimbursement to denied
	public void reimbursementDenied(Reimbursement r) {
		int id = r.getR_ID();
		String sql ="UPDATE reimbursements SET bc_approve = false, awarded = false, denial_reason = ? where rid = ?";
		try {
			PreparedStatement ps = Stmnt.makePrStmnt(sql);
			ps.setString(1, r.getDenialReason());
			ps.setInt(2, id);
			ps.executeUpdate();
			logit.LogIt("info", "Reimbursement: "+id+" for Employee ID: "+r.getEmpID()+" Was declined due to "+ r.getDenialReason());
		}catch  (SQLException e) {
			System.out.println("Check reimbursementDenied SQL " + e.getSQLState() + " " + e.getMessage());
		}
	}
	
	public double reimbursementAmountApproved( Reimbursement r) {
		EmployeeDAOImpl eImp = new EmployeeDAOImpl();
		Employee ex = eImp.getEmployeeById(r.getEmpID());
		double cost = r.getCost(); //full cost of th event
		double amount = 0;        // amount awarded
		double available = ex.getAvailableR(); //available 
		double pendingTotal =0 ;// pending requests from other reimbursement requests
		
		
	if (cost > 0 ) {	
		// applies the percentage of amount covered per event type
		String type = r.getEventType();
		  switch (type) {
		  case"University": 
			  amount = amount*.8;
			  break;
		  case"Seminar": 
			  amount = amount*.6;
			  break;
		  case"Certification Preparation": 
			  amount = amount*.75;
			  break;
		  case"Certification": 
			  amount = amount;
			  break;
		  case"Technical Training": 
			  amount = amount*.9;
			  break;
		  case"Other": 
			  amount = amount*.3;
			  break;
					  
		  }
		if (amount <= available) {
		ex.setAvailableR(available - amount);
		
		return amount;
	} else if (available < amount) {
		ex.setAvailableR(0);
		return available;
	}else { return 0;}
	}
	
	return 0 ;
	}
}
