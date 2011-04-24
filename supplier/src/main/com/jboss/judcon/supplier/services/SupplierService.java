package com.jboss.judcon.supplier.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/suppliers")
public class SupplierService {

	@GET
	@Produces(value = "text/plain")
	public String helloWorld() {
		return "Hello, world!";
	}
}