package com.jboss.judcon.supplier.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.hibernate.type.TrueFalseType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import com.jboss.judcon.supplier.utilities.MessageUtility;

@Name("SupplierService")
@Path("/suppliers")
public class SupplierService {
	
	@In(create=true, value="MessageUtility")
	MessageUtility messageUtility;

	@GET
	@Produces(value = "text/plain")
	public String helloWorld() {
		return messageUtility.getDefaultMessage();
	}
}