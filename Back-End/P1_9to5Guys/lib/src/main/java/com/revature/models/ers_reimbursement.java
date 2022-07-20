package com.revature.models;

public class ers_reimbursement {
	
	private int reimb_id;
	private int reimb_amount;
	private String reimb_submitted;
	private String reimb_resolved;
	private String reimb_description;
	
	// make assumptions and clean later
	private int reimb_author; // FK User
	private int reimb_resolver; // FK User
	private int reimb_status_id; // FK Status
	private int reimb_type_id; // FK Type
	
	// bring in the objects
	public ers_users employee_user;
	 
	public ers_users manager_user;
	
	public ers_reimbursement_status reimb_status;
	
	public ers_reimbursement_type reimb_type;

	// generate stuff
	public ers_reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	// all args... idky
	public ers_reimbursement(int reimb_id, int reimb_amount, String reimb_submitted, String reimb_resolved,
			String reimb_description, int reimb_author, int reimb_resolver, int reimb_status_id, int reimb_type_id,
			ers_users employee_user, ers_users manager_user, ers_reimbursement_status reimb_status,
			ers_reimbursement_type reimb_type) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
		this.employee_user = employee_user;
		this.manager_user = manager_user;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
	}

	// without objects
	public ers_reimbursement(int reimb_id, int reimb_amount, String reimb_submitted, String reimb_resolved,
			String reimb_description, int reimb_author, int reimb_resolver, int reimb_status_id, int reimb_type_id) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}

	// creating a new reimbursement
	public ers_reimbursement(int reimb_amount, String reimb_submitted, String reimb_resolved, String reimb_description,
			int reimb_author, int reimb_resolver, int reimb_status_id, int reimb_type_id) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}

	@Override
	public String toString() {
		return "ers_reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_author=" + reimb_author + ", reimb_resolver=" + reimb_resolver + ", reimb_status_id="
				+ reimb_status_id + ", reimb_type_id=" + reimb_type_id + ", employee_user=" + employee_user
				+ ", manager_user=" + manager_user + ", reimb_status=" + reimb_status + ", reimb_type=" + reimb_type
				+ "]";
	}

	//getters and setters 
	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public int getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public String getReimb_submitted() {
		return reimb_submitted;
	}

	public void setReimb_submitted(String reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public String getReimb_resolved() {
		return reimb_resolved;
	}

	public void setReimb_resolved(String reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public int getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}

	public int getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	public ers_users getEmployee_user() {
		return employee_user;
	}

	public void setEmployee_user(ers_users employee_user) {
		this.employee_user = employee_user;
	}

	public ers_users getManager_user() {
		return manager_user;
	}

	public void setManager_user(ers_users manager_user) {
		this.manager_user = manager_user;
	}

	public ers_reimbursement_status getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(ers_reimbursement_status reimb_status) {
		this.reimb_status = reimb_status;
	}

	public ers_reimbursement_type getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(ers_reimbursement_type reimb_type) {
		this.reimb_type = reimb_type;
	}
	
	
	
	
	
	
	
	
}
