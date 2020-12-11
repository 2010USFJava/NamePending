package com.revature.dao;


import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.data.Pending;

public interface ReimbursementDAO {
	public void submitReimbursement(Reimbursement form);
	public List<Pending> getPendingReimbursement();
}
