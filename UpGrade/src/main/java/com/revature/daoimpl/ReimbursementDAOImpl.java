package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.data.Pending;
import com.revature.service.EmployeeService;
import com.revature.utility.ConnFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	HashMap<Employee, Reimbursement> x = new HashMap<Employee, Reimbursement>();
	
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
			String sql = "INSERT INTO reimbursements VALUES (DEFAULT,?,?,TO_DATE(?,'DDMMYYYY'),TO_TIMESTAMP(?,'HH12:MI:SS'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, form.getEmpID());
			ps.setString(2, form.getEventName());
			ps.setString(3, form.getDate());
			ps.setString(4, form.getTime());
			ps.setString(5, form.getLocation());
			ps.setString(6, form.getLocation());
			ps.setString(7, form.getLocation());
			ps.setString(8, form.getDescription());
			ps.setDouble(9, form.getCost());
			ps.setString(10, form.getEventFile());
			ps.setString(11, form.getGradingFormat());
			ps.setString(12, form.getEventType());
			ps.setString(13, form.getJustification());
			ps.setString(14, form.getApprovalFile());
			ps.setInt(13, form.getDsApproval());
			ps.setInt(15, form.getDhApproval());
			ps.setBoolean(16, form.isBcApproval());
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
	public Pending getPendingReimbursement() {
		
		Employee emp = new Employee();
		Reimbursement r = new Reimbursement();
		Pending p = null;
		PreparedStatement ps;
		try {
			Connection conn = cf.getConnection();
			String sql = "select first_name, last_name, event_name, event_date, ds_approve, dh_approve from reimbursements inner join employees on reimbursements.empid = employees.empid where bc_approve=false";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emp.setFirstName(rs.getString(1));
				emp.setLastName(rs.getString(2));
				r.setEventName(rs.getString(3));
				r.setDate(rs.getString(4));
				r.setDsApproval(rs.getInt(5));
				r.setDhApproval(rs.getInt(6));
				p = new Pending(emp, r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(p);
		return p;
	}
	
	
}
