package com.revature.dao;


import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.data.Pending;

public interface ReimbursementDAO {
	public void submitReimbursement(Reimbursement form, Employee emp);
	public List<Pending> getPendingReimbursement();
	public List<Reimbursement> getAllReimbursement(int empID);
	public Reimbursement getOneReimbursement(int rID);
}
