package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.ConditionService;

@Path("condition")
public class ConditionController {
	
	@Inject
	ConditionService conSer;
	
	@Path("getAllConditions")
	@GET
	@Produces({ "application/json" })
	public String getAllConditions() {
		return conSer.getAllConditions();
	}
	
	@Path("findACondition/{id}")
	@GET
	@Produces({ "application/json" })
	public String findACondition(@PathParam("id") int id) {
		return conSer.findACondition(id);
	}
	
//	@Path("findConditionByName/{conditionName}")
//	@GET
//	@Produces({ "application/json" })
//	public String findConditionByName(@PathParam("conditionName") String conditionName) {
//		return conSer.findConditionByName(conditionName);
//	}
	
	@Path("addCondition")
	@POST
	@Produces({ "application/json" })
	public String addCondition(String conditionName) {
		return conSer.addCondition(conditionName);
	}
	
	@Path("deleteCondition/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteCondition(@PathParam("id") int id) {
		return conSer.deleteCondition(id);
	}
	
	@Path("updateCondition/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateCondition(@PathParam("id") int id, String conditionName) {
		return conSer.updateCondition(id, conditionName);
	}

}
