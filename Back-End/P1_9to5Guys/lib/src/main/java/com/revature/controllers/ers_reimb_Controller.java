package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.ers_reimbDAO;
import com.revature.models.ers_reimbursement;

import io.javalin.http.Handler;

public class ers_reimb_Controller {
	
	ers_reimbDAO reDAO = new ers_reimbDAO();
	
	public Handler submitreimbHandler = (ctx) -> {
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		ers_reimbursement newReimb = gson.fromJson(body, ers_reimbursement.class);
		
		if(reDAO.submitReimb(newReimb)) {
			
			ctx.status(202);
		
		} else {
			ctx.status(406);
		}
	};
	
	public Handler viewAllReimbursementsbyUserHandler = (ctx) -> {
	
		String reimb_author = ctx.pathParam("reimb_author");
		int id = Integer.parseInt(reimb_author);
		
		ArrayList<ers_reimbursement> reimbs = reDAO.viewAllReimbursementsbyUser(id);
		
		Gson gson = new Gson();
		
		
		String usersReimbs = gson.toJson(reimbs);
		
		if(usersReimbs != null) {
			ctx.result(usersReimbs);
			ctx.status(202);
			
		} else {
			ctx.status(401);
		}
		
		
	};
	
	public Handler viewAllReimbursementsHandler = (ctx) -> {
		
		ArrayList<ers_reimbursement> reimbs = reDAO.viewAllReimbursements();
		
		Gson gson = new Gson();
		
		
		String allReimbs = gson.toJson(reimbs);
		
		if(allReimbs != null) {
			ctx.result(allReimbs);
			ctx.status(202);
			
		} else {
			ctx.status(401);
		}
		
		
	};
	
	public Handler viewAllReimbursementsbyTypeHandler = (ctx) -> {
		
		String reimb_type_id = ctx.pathParam("reimb_type_id");
		int id = Integer.parseInt(reimb_type_id);
	
		ArrayList<ers_reimbursement> reimbs = reDAO.viewAllReimbursementsbyType(id);
		
		Gson gson = new Gson();
		
		
		String typeReimbs = gson.toJson(reimbs);
		
		if(typeReimbs != null) {
			ctx.result(typeReimbs);
			ctx.status(202);
			
		} else {
			ctx.status(401);
		}
		
		
	};
	
	public Handler resolveRequestHandler = (ctx) -> {
		// collect user data for new resolver id
		// we current have the use of an object in the param
		
		String reimb_id = ctx.pathParam("reimb_id");
		int form_id = Integer.parseInt(reimb_id);
		
		String jSon = ctx.body();
		System.out.println(jSon);
		
		Gson g = new Gson();
		ers_reimbursement e = g.fromJson(jSon, ers_reimbursement.class);
		
		int resolver_id = e.getReimb_resolver();
		int status_id = e.getReimb_status_id();
		
		
		if(reDAO.resolveRequest(form_id, resolver_id, status_id)) {
			ctx.status(202);
			System.out.println("You have resolved the Reimbursement request.");
		
		} else {
			ctx.status(406);
			System.out.println("You have failed to resolve the request.");
		
		}
		
	};
	
	
	
	
	
	
	
	
	
	
}
