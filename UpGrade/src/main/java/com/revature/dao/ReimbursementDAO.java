package com.revature.dao;

import com.revature.beans.Reimbursement;
import com.revature.data.Pending;

public interface ReimbursementDAO {
	public void submitReimbursement(Reimbursement form);
	public Pending getPendingReimbursement();
}
