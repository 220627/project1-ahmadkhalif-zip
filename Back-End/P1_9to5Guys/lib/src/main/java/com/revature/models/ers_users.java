package com.revature.models;

public class ers_users {

	private int user_id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String user_email;
	private int user_role_id;
	
	public ers_user_roles user_role;

	public ers_users() {
		super();
		// TODO Auto-generated constructor stub
	}

	// all args
	public ers_users(int user_id, String username, String password, String first_name, String last_name,
			String user_email, int user_role_id, ers_user_roles user_role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.user_role_id = user_role_id;
		this.user_role = user_role;
	}

	// minus role object
	public ers_users(int user_id, String username, String password, String first_name, String last_name,
			String user_email, int user_role_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.user_role_id = user_role_id;
	}

	// minus object and id for user creation
	public ers_users(String username, String password, String first_name, String last_name, String user_email,
			int user_role_id) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.user_role_id = user_role_id;
	}

	
	
	
	// minus object and password
	public ers_users(int user_id, String username, String first_name, String last_name, String user_email,
			int user_role_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.user_role_id = user_role_id;
	}

	// toString
	@Override
	public String toString() {
		return "ers_users [user_id=" + user_id + ", username=" + username + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", user_email=" + user_email + ", user_role_id="
				+ user_role_id + ", user_role=" + user_role + "]";
	}

	
	//getters and setters
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

	public ers_user_roles getUser_role() {
		return user_role;
	}

	public void setUser_role(ers_user_roles user_role) {
		this.user_role = user_role;
	}
	
	
	
	
	
	
	
	
	
}
