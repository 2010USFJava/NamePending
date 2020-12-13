package com.revature.daoimpl;

import java.io.IOException;
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
import com.revature.utility.Stmnt;
import com.revature.utility.logit;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	HashMap<Employee, Reimbursement> x = new HashMap<Employee, Reimbursement>();

	public static ConnFactory cf = ConnFactory.getInstance();
	EmployeeDAO empDao = new EmployeeDAOImpl();
	EmployeeService eServ = new EmployeeService();

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void submitReimbursement(Reimbursement form, Employee emp) {
		try {
			Connection conn = cf.getConnection();
			String sql = "INSERT INTO reimbursements "
					+ "(empid, event_name, event_date, event_time, event_location, description, event_cost, event_file, gradingformat, event_type, justification, approval_file)"
					+ "VALUES (?,?,TO_DATE(?,'YYYY-MM-DD'),TO_TIMESTAMP(?,'HH24:MI:SS'),?,?,?,?,?,?,?,?)";
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
			ps.execute();
			String empSql = "UPDATE employees set ds_id = ?, dh_id = ? where empid = ?";
			PreparedStatement empPs = conn.prepareStatement(empSql);
			empPs.setInt(1, emp.getSupervisorID());
			empPs.setInt(2, emp.getDeptHeadID());
			empPs.setInt(3, emp.getEmpID());
			empPs.execute();
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
			String sql = "select rid, reimbursements.empid, first_name, last_name, event_name, event_date, ds_approve, dh_approve from reimbursements inner join employees on reimbursements.empid = employees.empid where bc_approve is null";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
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

	@Override
	public List<Reimbursement> getAllReimbursement(int empID) {
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		PreparedStatement ps;
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM reimbursements where empid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rList.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getInt(14),
						rs.getInt(15), rs.getBoolean(16), rs.getDouble(17), rs.getString(18), rs.getBoolean(19),
						rs.getBoolean(20), rs.getString(21)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rList;
	}

	@Override
	public Reimbursement getOneReimbursement(int rID) {
		Reimbursement rObj = new Reimbursement();
		PreparedStatement ps;
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM reimbursements where rid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rObj.setEmpID(rs.getInt(2));
				rObj.setR_ID(rs.getInt(1));
				rObj.setEventName(rs.getString(3));
				rObj.setDate(rs.getString(4));
				rObj.setTime(rs.getString(5));
				rObj.setLocation(rs.getString(6));
				rObj.setDescription(rs.getString(7));
				rObj.setCost(rs.getDouble(8));
				rObj.setEventFile(rs.getString(9));
				rObj.setGradingFormat(rs.getString(10));
				rObj.setEventType(rs.getString(11));
				rObj.setJustification(rs.getString(12));
				rObj.setApprovalFile(rs.getString(13));
				rObj.setDsApproval(rs.getInt(14));
				rObj.setDhApproval(rs.getInt(15));
				rObj.setBcApproval(rs.getBoolean(16));
				rObj.setAlteredAmt(rs.getDouble(17));
				rObj.setAlteredReason(rs.getString(18));
				rObj.setExceedingFunds(rs.getBoolean(19));
				rObj.setAwarded(rs.getBoolean(20));
				rObj.setDenialReason(rs.getString(21));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rObj;
	}

	@Override
	public List<Pending> getDSReimbursement() {
		List<Pending> pendingList = new ArrayList<Pending>();
		PreparedStatement ps;
		try {
			Connection conn = cf.getConnection();
			String sql = "select rid, reimbursements.empid, first_name, last_name, event_name, event_date, dh_approve, bc_approve from reimbursements inner join employees on reimbursements.empid = employees.empid where ds_approve is null";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
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

	@Override
	public List<Pending> getDHReimbursement() {
		List<Pending> pendingList = new ArrayList<Pending>();
		PreparedStatement ps;
		try {
			Connection conn = cf.getConnection();
			String sql = "select rid, reimbursements.empid, first_name, last_name, event_name, event_date, ds_approve, bc_approve from reimbursements inner join employees on reimbursements.empid = employees.empid where dh_approve is null";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
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

	// search reimbursements by ID
	public Reimbursement getReimbursementByID(int id) {
		String sql = "SELECT * FROM reimbursements WHERE rid =? ";
		Reimbursement r = null;
		try {
			PreparedStatement ps = Stmnt.makePrStmnt(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				rs.equals(r);
				return r;
			}

		} catch (SQLException e) {
			System.out.println("Check getReimbursementByID SQL " + e.getSQLState() + " " + e.getMessage());
		}

		return null;
	}

	// update reimbursement to approved
	public void reimbursementApproved(Reimbursement r) {
		int id = r.getR_ID();
		String sql = "UPDATE reimbursements SET bc_approve = true  where rid = ? ";

		try {
			PreparedStatement ps = Stmnt.makePrStmnt(sql);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			// System.out.println("Check reimbursementApproved SQL " + e.getSQLState() + " "
			// + e.getMessage());
		}
		try {
			logit.LogIt("info", "Reimbursement: " + id + " for Employee ID: " + r.getEmpID() + " Was Approved");
		} catch (IOException e) {
		} catch (SQLException e) {
		}
	}

	// update reimbursement to denied
	public void reimbursementDenied(Reimbursement r) throws IOException {
		int id = r.getR_ID();
		String sql = "UPDATE reimbursements SET bc_approve = false, awarded = false, denial_reason = ? where rid = ?";
		try {
			PreparedStatement ps = Stmnt.makePrStmnt(sql);
			ps.setString(1, r.getDenialReason());
			ps.setInt(2, id);
			ps.executeUpdate();
			logit.LogIt("info", "Reimbursement: " + id + " for Employee ID: " + r.getEmpID() + " Was declined due to "
					+ r.getDenialReason());
		} catch (SQLException e) {
			System.out.println("Check reimbursementDenied SQL " + e.getSQLState() + " " + e.getMessage());
		}
	}

	public double reimbursementAmountApproved(Reimbursement r) {
		EmployeeDAOImpl eImp = new EmployeeDAOImpl();
		Employee ex = eImp.getEmployeeById(r.getEmpID());
		double cost = r.getCost(); // full cost of th event
		double amount = 0; // amount awarded
		double available = ex.getAvailableR(); // available
		double pendingTotal = 0;// pending requests from other reimbursement requests

		if (cost > 0) {
			// applies the percentage of amount covered per event type
			String type = r.getEventType();
			switch (type) {
			case "University":
				amount = amount * .8;
				break;
			case "Seminar":
				amount = amount * .6;
				break;
			case "Certification Preparation":
				amount = amount * .75;
				break;
			case "Certification":
				amount = amount;
				break;
			case "Technical Training":
				amount = amount * .9;
				break;
			case "Other":
				amount = amount * .3;
				break;

			}
			if (amount <= available) {
				ex.setAvailableR(available - amount);

				return amount;
			} else if (available < amount) {
				ex.setAvailableR(0);
				return available;
			} else {
				return 0;
			}
		}

		return 0;
	}

	@Override
	public List<Reimbursement> getEveryReimbursement() {
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		PreparedStatement ps;
		try {
			Connection conn = cf.getConnection();
			String sql = "SELECT * FROM reimbursements";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rList.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getInt(14),
						rs.getInt(15), rs.getBoolean(16), rs.getDouble(17), rs.getString(18), rs.getBoolean(19),
						rs.getBoolean(20), rs.getString(21)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rList;
	}
}
