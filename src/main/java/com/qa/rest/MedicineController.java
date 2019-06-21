package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.MedicineService;

@Path("medicine")
public class MedicineController {
	
	@Inject
	MedicineService medSer;
	
	@Path("getAllMedicines")
	@GET
	@Produces({ "application/json" })
	public String getAllMedicines() {
		return medSer.getAllMedicines();
	}
	
	@Path("findAMedicine/{id}")
	@GET
	@Produces({ "application/json" })
	public String findAMedicine(@PathParam("id") int id) {
		return medSer.findAMedicine(id);
	}
	
	@Path("addMedicine")
	@POST
	@Produces({ "application/json" })
	public String addMedicine(String drugName) {
		return medSer.addMedicine(drugName);
	}
	
	@Path("deleteMedicine/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteMedicine(@PathParam("id") int id) {
		return medSer.deleteMedicine(id);
	}
	
	@Path("updateMedicine/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateMedicine(@PathParam("id") int id, String drugName) {
		return medSer.updateMedicine(id, drugName);
	}
}
