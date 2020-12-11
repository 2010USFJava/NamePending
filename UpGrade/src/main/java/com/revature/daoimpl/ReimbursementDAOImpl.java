package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
			ps.setString(6, form.getDescription());
			ps.setDouble(7, form.getCost());
			ps.setString(8, form.getEventFile());
			ps.setString(9, form.getGradingFormat());
			ps.setString(10, form.getEventType());
			ps.setString(11, form.getJustification());
			ps.setString(12, form.getApprovalFile());
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
	public List<Pending> getPendingReimbursement() {
		List<Pending> pendingList = new ArrayList<Pending>();
		PreparedStatement ps;
		try {
			Connection conn = cf.getConnection();
			String sql = "select rid, reimbursements.empid, first_name, last_name, event_name, event_date, ds_approve, dh_approve from reimbursements inner join employees on reimbursements.empid = employees.empid where bc_approve=false";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				Employee emp = new Employee();
				Reimbursement r = new Reimbursement();
				emp.setEmpID(rs.getInt(2));
				emp.setFirstName(rs.getString(3));
				emp.setLastName(rs.getString(4));
				r.setR_ID(rs.getInt(1));
				r.setEventName(rs.getString(5));
				r.setDate(rs.getString(6));
				r.setDsApproval(rs.getInt(7));
				r.setDhApproval(rs.getInt(8));
				pendingList.add(new Pending(emp, r));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(pendingList);
		return pendingList;
	}
	
	
}
