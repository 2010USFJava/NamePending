package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	public void submitReimbursement(Reimbursement form);
	public List<Reimbursement> getPendingReimbursement();
}
