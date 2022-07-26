package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.models.ers_users;
import com.revature.services.ers_user_loginService;

import io.javalin.http.Handler;

public class ers_users_Controller {
	
	//instantiate logger object so that we can achieve logging (you can do logging or testing for P1)
	public static Logger Log = LogManager.getLogger();

	// we need an AuthService. remember the service layer sits between the Controllers and DAOs
	ers_user_loginService UserServe = new ers_user_loginService();
		
		//empty HttpSession object that will be filled upon successful login
		public static HttpSession ses;
		
		// we need a loginHandler to take in Login Data, make a LoginDTO, and send it to the service
		// if login is successful, the service sends back a String which we use in our return (ctx.result())
		// we test whether the login service returns null or a String
		// also a session will be created when the user logs in successfully
		
		// login will be a post request, check insertEmployeeHandler if any of this syntax eludes you
		public Handler loginHandler = (ctx) -> {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			ers_users collectedKeys = gson.fromJson(body, ers_users.class);
			
			ers_users user = UserServe.login(collectedKeys.getUsername(), collectedKeys.getPassword());
			
			if(user != null) { // if login is successful...
				
				// log that the user logged in successfully
				Log.info("User: " + collectedKeys.getUsername() + " Logged In");
				
				ses = ctx.req.getSession(); // this is how we create new sessions
				
				String userJSON = gson.toJson(user); // turns the returned user into JSON
				
				ctx.result(userJSON); // sends the user to the front end
				
				// is this below necessary...?
				//ctx.cookieStore("user_id", collectedKeys.getUser_id());
				int current_user_id = user.getUser_id();
				System.out.println(current_user_id);
				
				ctx.status(202); // 202 stands for "accepted"
				System.out.println("login successful");
				
			} else {
				// log that the user failed to log in
				Log.info("User: " + collectedKeys.getUsername() + " Failed to Log In");
				
				ctx.status(401); // 401 stands for "unauthorized"
				System.out.println("login unsuccessful");
			}
			
		};
}
