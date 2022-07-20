package com.revature.models;

public class ers_reimbursement_status {
	
	private int reimbursement_status_id;
	private String reimbursement_status;
	
	
	public ers_reimbursement_status() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ers_reimbursement_status(int reimbursement_status_id, String reimbursement_status) {
		super();
		this.reimbursement_status_id = reimbursement_status_id;
		this.reimbursement_status = reimbursement_status;
	}


	// toString 
	@Override
	public String toString() {
		return "ers_reimbursement_status [reimbursement_status_id=" + reimbursement_status_id
				+ ", reimbursement_status=" + reimbursement_status + "]";
	}


	// getters and setters
	public int getReimbursement_status_id() {
		return reimbursement_status_id;
	}


	public void setReimbursement_status_id(int reimbursement_status_id) {
		this.reimbursement_status_id = reimbursement_status_id;
	}


	public String getReimbursement_status() {
		return reimbursement_status;
	}


	public void setReimbursement_status(String reimbursement_status) {
		this.reimbursement_status = reimbursement_status;
	}
	
	
	
	
}
