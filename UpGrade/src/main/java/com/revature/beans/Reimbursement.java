package com.revature.beans;

public class Reimbursement {
	private int requestID;
	private int empID;
	private String eventName;
	private String eventDate;
	private String eventTime;
	private String eventLocation;
	private String description;
	private double eventCost;
	private String eventFile;
	private String gradingFormat;
	private String eventType;
	private String justification;
	private String approvalFile;
	private int dsApprove;
	private int dhApprove;
	private boolean bcApprove;
	private int alteredAmount;
	private String alteredReason;
	private boolean exceedingFunds;
	private boolean awarded;
	private String denialReason;
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int empID, String eventName, String eventDate, String eventTime, String eventLocation,
			String description, double eventCost, String eventFile, String gradingFormat, String eventType,
			String justification, String approvalFile, int dsApprove, int dhApprove, boolean bcApprove,
			int alteredAmount, String alteredReason, boolean exceedingFunds, boolean awarded, String denialReason) {
		super();
		this.empID = empID;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventLocation = eventLocation;
		this.description = description;
		this.eventCost = eventCost;
		this.eventFile = eventFile;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.justification = justification;
		this.approvalFile = approvalFile;
		this.dsApprove = dsApprove;
		this.dhApprove = dhApprove;
		this.bcApprove = bcApprove;
		this.alteredAmount = alteredAmount;
		this.alteredReason = alteredReason;
		this.exceedingFunds = exceedingFunds;
		this.awarded = awarded;
		this.denialReason = denialReason;
	}

	public Reimbursement(int requestID, int empID, String eventName, String eventDate, String eventTime, String eventLocation,
			String description, double eventCost, String eventFile, String gradingFormat, String eventType,
			String justification, String approvalFile, int dsApprove, int dhApprove, boolean bcApprove,
			int alteredAmount, String alteredReason, boolean exceedingFunds, boolean awarded, String denialReason) {
		super();
		this.requestID = requestID;
		this.empID = empID;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventLocation = eventLocation;
		this.description = description;
		this.eventCost = eventCost;
		this.eventFile = eventFile;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.justification = justification;
		this.approvalFile = approvalFile;
		this.dsApprove = dsApprove;
		this.dhApprove = dhApprove;
		this.bcApprove = bcApprove;
		this.alteredAmount = alteredAmount;
		this.alteredReason = alteredReason;
		this.exceedingFunds = exceedingFunds;
		this.awarded = awarded;
		this.denialReason = denialReason;
	}
	public int getRequestID() {
		return requestID;
	}
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getEventCost() {
		return eventCost;
	}
	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}
	public String getEventFile() {
		return eventFile;
	}
	public void setEventFile(String eventFile) {
		this.eventFile = eventFile;
	}
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getApprovalFile() {
		return approvalFile;
	}
	public void setApprovalFile(String approvalFile) {
		this.approvalFile = approvalFile;
	}
	public int getDsApprove() {
		return dsApprove;
	}
	public void setDsApprove(int dsApprove) {
		this.dsApprove = dsApprove;
	}
	public int getDhApprove() {
		return dhApprove;
	}
	public void setDhApprove(int dhApprove) {
		this.dhApprove = dhApprove;
	}
	public boolean isBcApprove() {
		return bcApprove;
	}
	public void setBcApprove(boolean bcApprove) {
		this.bcApprove = bcApprove;
	}
	public int getAlteredAmount() {
		return alteredAmount;
	}
	public void setAlteredAmount(int alteredAmount) {
		this.alteredAmount = alteredAmount;
	}
	public String getAlteredReason() {
		return alteredReason;
	}
	public void setAlteredReason(String alteredReason) {
		this.alteredReason = alteredReason;
	}
	public boolean isExceedingFunds() {
		return exceedingFunds;
	}
	public void setExceedingFunds(boolean exceedingFunds) {
		this.exceedingFunds = exceedingFunds;
	}
	public boolean isAwarded() {
		return awarded;
	}
	public void setAwarded(boolean awarded) {
		this.awarded = awarded;
	}
	public String getDenialReason() {
		return denialReason;
	}
	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}
	@Override
	public String toString() {
		return "Reimbursement [requestID=" + requestID + ", empID=" + empID + ", eventName=" + eventName
				+ ", eventTime=" + eventTime + ", eventLocation=" + eventLocation + ", description=" + description
				+ ", eventCost=" + eventCost + ", eventFile=" + eventFile + ", gradingFormat=" + gradingFormat
				+ ", eventType=" + eventType + ", justification=" + justification + ", approvalFile=" + approvalFile
				+ ", dsApprove=" + dsApprove + ", dhApprove=" + dhApprove + ", bcApprove=" + bcApprove
				+ ", alteredAmount=" + alteredAmount + ", alteredReason=" + alteredReason + ", exceedingFunds="
				+ exceedingFunds + ", awarded=" + awarded + ", denialReason=" + denialReason + "]";
	}
	
}
