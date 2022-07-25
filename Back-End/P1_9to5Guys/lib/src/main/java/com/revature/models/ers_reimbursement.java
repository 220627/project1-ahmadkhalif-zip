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
	
	// no more object collision only bonus attributes to fill
	// author Strings
	private String reimb_author_username;
	private String reimb_author_first_name;
	private String reimb_author_last_name;
	private String reimb_author_email;
	
	// resolver Strings
	private String reimb_resolver_username;
	private String reimb_resolver_first_name;
	private String reimb_resolver_last_name;
	private String reimb_resolver_email;
	
	// status String
	private String reimb_status_text;
	
	// reimb type String
	private String reimb_type_text;
	
	// generate stuff
	public ers_reimbursement() {
		super();
		// TODO Auto-generated constructor stub
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
	
	// format for viewing reimbursement select from join
	public ers_reimbursement(int reimb_id, int reimb_amount, String reimb_submitted, String reimb_resolved,
			String reimb_description, String reimb_author_username, String reimb_author_first_name,
			String reimb_author_last_name, String reimb_author_email, String reimb_resolver_username,
			String reimb_resolver_first_name, String reimb_resolver_last_name, String reimb_resolver_email,
			String reimb_status_text, String reimb_type_text) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author_username = reimb_author_username;
		this.reimb_author_first_name = reimb_author_first_name;
		this.reimb_author_last_name = reimb_author_last_name;
		this.reimb_author_email = reimb_author_email;
		this.reimb_resolver_username = reimb_resolver_username;
		this.reimb_resolver_first_name = reimb_resolver_first_name;
		this.reimb_resolver_last_name = reimb_resolver_last_name;
		this.reimb_resolver_email = reimb_resolver_email;
		this.reimb_status_text = reimb_status_text;
		this.reimb_type_text = reimb_type_text;
	}

	
	// e v e r y t h i n g
	public ers_reimbursement(int reimb_id, int reimb_amount, String reimb_submitted, String reimb_resolved,
			String reimb_description, int reimb_author, int reimb_resolver, int reimb_status_id, int reimb_type_id,
			String reimb_author_username, String reimb_author_first_name, String reimb_author_last_name,
			String reimb_author_email, String reimb_resolver_username, String reimb_resolver_first_name,
			String reimb_resolver_last_name, String reimb_resolver_email, String reimb_status_text,
			String reimb_type_text) {
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
		this.reimb_author_username = reimb_author_username;
		this.reimb_author_first_name = reimb_author_first_name;
		this.reimb_author_last_name = reimb_author_last_name;
		this.reimb_author_email = reimb_author_email;
		this.reimb_resolver_username = reimb_resolver_username;
		this.reimb_resolver_first_name = reimb_resolver_first_name;
		this.reimb_resolver_last_name = reimb_resolver_last_name;
		this.reimb_resolver_email = reimb_resolver_email;
		this.reimb_status_text = reimb_status_text;
		this.reimb_type_text = reimb_type_text;
	}

	@Override
	public String toString() {
		return "ers_reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_author=" + reimb_author + ", reimb_resolver=" + reimb_resolver + ", reimb_status_id="
				+ reimb_status_id + ", reimb_type_id=" + reimb_type_id + ", reimb_author_username="
				+ reimb_author_username + ", reimb_author_first_name=" + reimb_author_first_name
				+ ", reimb_author_last_name=" + reimb_author_last_name + ", reimb_author_email=" + reimb_author_email
				+ ", reimb_resolver_username=" + reimb_resolver_username + ", reimb_resolver_first_name="
				+ reimb_resolver_first_name + ", reimb_resolver_last_name=" + reimb_resolver_last_name
				+ ", reimb_resolver_email=" + reimb_resolver_email + ", reimb_status_text=" + reimb_status_text
				+ ", reimb_type_text=" + reimb_type_text + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

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

	public String getReimb_author_username() {
		return reimb_author_username;
	}

	public void setReimb_author_username(String reimb_author_username) {
		this.reimb_author_username = reimb_author_username;
	}

	public String getReimb_author_first_name() {
		return reimb_author_first_name;
	}

	public void setReimb_author_first_name(String reimb_author_first_name) {
		this.reimb_author_first_name = reimb_author_first_name;
	}

	public String getReimb_author_last_name() {
		return reimb_author_last_name;
	}

	public void setReimb_author_last_name(String reimb_author_last_name) {
		this.reimb_author_last_name = reimb_author_last_name;
	}

	public String getReimb_author_email() {
		return reimb_author_email;
	}

	public void setReimb_author_email(String reimb_author_email) {
		this.reimb_author_email = reimb_author_email;
	}

	public String getReimb_resolver_username() {
		return reimb_resolver_username;
	}

	public void setReimb_resolver_username(String reimb_resolver_username) {
		this.reimb_resolver_username = reimb_resolver_username;
	}

	public String getReimb_resolver_first_name() {
		return reimb_resolver_first_name;
	}

	public void setReimb_resolver_first_name(String reimb_resolver_first_name) {
		this.reimb_resolver_first_name = reimb_resolver_first_name;
	}

	public String getReimb_resolver_last_name() {
		return reimb_resolver_last_name;
	}

	public void setReimb_resolver_last_name(String reimb_resolver_last_name) {
		this.reimb_resolver_last_name = reimb_resolver_last_name;
	}

	public String getReimb_resolver_email() {
		return reimb_resolver_email;
	}

	public void setReimb_resolver_email(String reimb_resolver_email) {
		this.reimb_resolver_email = reimb_resolver_email;
	}

	public String getReimb_status_text() {
		return reimb_status_text;
	}

	public void setReimb_status_text(String reimb_status_text) {
		this.reimb_status_text = reimb_status_text;
	}

	public String getReimb_type_text() {
		return reimb_type_text;
	}

	public void setReimb_type_text(String reimb_type_text) {
		this.reimb_type_text = reimb_type_text;
	}
	
	
	
	
	
	
}
