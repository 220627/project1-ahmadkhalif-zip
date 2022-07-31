package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.ers_reimb_Controller;
import com.revature.controllers.ers_users_Controller;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	//Instantiate a Logger object so that we can achieve logging (you can either do logging OR testing for P1)
	//public static Logger log = LogManager.getLogger();
			
	public static void main(String[] args) {
		
		// try with resources for testing connection
				try(Connection conn = ConnectionUtil.getConnection()){
					System.out.println("CONNECTION SUCCESSFUL :)");
				
				} catch (SQLException e) {
					// if connection fails to open, catch the resulting SQLException and print the stack trace (error log)
					System.out.println("connection failed...");
					e.printStackTrace();
				
				} // end of the connection test

				
				// Typical Javalin syntax to create a javalin object
				Javalin app = Javalin.create(
						
						// the config lamda lets us specify certain vonfigs for our Javalin app
						config -> {
							config.enableCorsForAllOrigins(); // this lets us process HTTP requests from any origin
						}
						
						).start(4000); // we need .start to start our Java server on port 3000
						// this port is important because this is where we need to send requests to.
						
				// we need endpoint handlers which will take in requests and sent them where they need to go
				// Javalin endpoint handlers take HTTP traffic and direct it
				
				// instantiate employee controller so that we can use its handlers. 
				ers_users_Controller uc = new ers_users_Controller();
				
				//instantiate a RoleController so that we can use its handler
				ers_reimb_Controller rc = new ers_reimb_Controller();
								
				
				//endpoint handlers below-------------
					
				
				
				// this handler takes in GET requests. it will return all employees from the database
				//app.get is the javalin method that takes GET requests.
				//the request in postman would look something like localhost:3000/employees
				app.post("/create_reimbursement", rc.submitreimbHandler);
				//we want requests ending in /employees to get all employees
				
				// the app.post() is the method that takes in POST requests. It will insert employee data into the DB.
				//how come we can have two endpoints of "/employees"? that's because one is for GET and the other is POST
				app.post("/my_reimbursements/", rc.viewAllReimbursementsbyUserHandler);
				
				app.get("/view_reimbursements", rc.viewAllReimbursementsHandler);
				
				app.post("/view_reimbursements/:reimb_type_id", rc.viewAllReimbursementsbyTypeHandler);
				
				app.put("/view_reimbursements/:reimb_id", rc.resolveRequestHandler);
				
				// login stuff --------------------------------------------------
				app.post("/login", uc.loginHandler); 
				
				app.before("/view_reimbursements/*", ctx -> {
					// can i get the cookie here?
					//int id = current_user_id;
				}); 
				// --------------------------------------------------------------
				//app.put is the javalin method that takes put request it will tke two pieces of data: the role title in the path parameter and the salary in the request body
				//:title? this is a PATH PARAMETER. Whatever the user inserts here in the requests will be used in the controller
				
				
					
		

		//log.info("Logging works");
		
	}

}
