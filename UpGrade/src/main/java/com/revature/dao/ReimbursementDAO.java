package com.revature.dao;


import java.io.IOException;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.data.Pending;

public interface ReimbursementDAO {
	public void submitReimbursement(Reimbursement form);
	public List<Pending> getPendingReimbursement();
	public List<Reimbursement> getAllReimbursement(int empID);
	public Reimbursement getOneReimbursement(int rID);
	public List<Pending> getDSReimbursement();
	public List<Pending> getDHReimbursement();
	public List<Reimbursement> getEveryReimbursement();
	public void reimbursementApproved(Reimbursement form);
	public void reimbursementDenied(Reimbursement form, String denialReason) throws IOException;
}
