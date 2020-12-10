package com.revature.data;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;

public class Pending {
	private Employee empObj;
	private Reimbursement rObj;
	
	public Employee getEmpObj() {
		return empObj;
	}
	public void setEmpObj(Employee empObj) {
		this.empObj = empObj;
	}
	public Reimbursement getrObj() {
		return rObj;
	}
	public void setrObj(Reimbursement rObj) {
		this.rObj = rObj;
	}
	
	public Pending() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pending(Employee empObj, Reimbursement rObj) {
		super();
		this.empObj = empObj;
		this.rObj = rObj;
	}
	
}
