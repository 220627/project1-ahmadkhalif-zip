package com.revature.models;

public class ers_reimbursement_type {

	private int reimbursement_type_id;
	private String reimbursement_type;
	
	public ers_reimbursement_type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ers_reimbursement_type(int reimbursement_type_id, String reimbursement_type) {
		super();
		this.reimbursement_type_id = reimbursement_type_id;
		this.reimbursement_type = reimbursement_type;
	}

	// in case I do make a new type
	public ers_reimbursement_type(String reimbursement_type) {
		super();
		this.reimbursement_type = reimbursement_type;
	}

	// toString
	@Override
	public String toString() {
		return "ers_reimbursement_type [reimbursement_type_id=" + reimbursement_type_id + ", reimbursement_type="
				+ reimbursement_type + "]";
	}

	// getters and setters.
	public int getReimbursement_type_id() {
		return reimbursement_type_id;
	}

	public void setReimbursement_type_id(int reimbursement_type_id) {
		this.reimbursement_type_id = reimbursement_type_id;
	}

	public String getReimbursement_type() {
		return reimbursement_type;
	}

	public void setReimbursement_type(String reimbursement_type) {
		this.reimbursement_type = reimbursement_type;
	}
	
	
	
	
	
}
