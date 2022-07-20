package com.revature.models;

public class ers_user_roles {
	
	private int ers_user_role_id;
	private String ers_user_role;
	
	// healthy classes
	public ers_user_roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ers_user_roles(int ers_user_role_id, String ers_user_role) {
		super();
		this.ers_user_role_id = ers_user_role_id;
		this.ers_user_role = ers_user_role;
	}

	// toString
	@Override
	public String toString() {
		return "ers_user_roles [ers_user_role_id=" + ers_user_role_id + ", ers_user_role=" + ers_user_role + "]";
	}

	// getters and setters
	public int getErs_user_role_id() {
		return ers_user_role_id;
	}

	public void setErs_user_role_id(int ers_user_role_id) {
		this.ers_user_role_id = ers_user_role_id;
	}

	public String getErs_user_role() {
		return ers_user_role;
	}

	public void setErs_user_role(String ers_user_role) {
		this.ers_user_role = ers_user_role;
	}

	
	
}
