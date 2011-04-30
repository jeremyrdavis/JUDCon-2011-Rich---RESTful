package com.jboss.judcon.application.service;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboss.judcon.entities.Customer;
import com.jboss.judcon.entities.Supplier;
import com.jboss.judcon.utilities.DAOMock;

@Path("/rest/customer")
public class CustomerService
{
	Logger log = LoggerFactory.getLogger(CustomerService.class);
		
	@GET
	@Produces("application/json")
	public StreamingOutput getCustomerJson()
	{
		final Customer cust = DAOMock.getCustomer();

		if (cust == null) 
		{
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		
		// return the customer json object
		return new StreamingOutput() 
		{
			public void write( OutputStream outputStream ) throws IOException, WebApplicationException 
			{
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(outputStream, cust);
			}
		};
	}

	@GET
	@Produces("application/xml")
	public Supplier getSupplierXml() {
		final Supplier supplier = DAOMock.getSupplier();

		if (supplier == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return supplier;

	};
}
