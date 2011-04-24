package com.jboss.judcon.application.service;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboss.judcon.entities.Order;
import com.jboss.judcon.utilities.DAOMock;

@Path("order")
public class OrderService
{
	private Logger log = LoggerFactory.getLogger(ProduceService.class);
	
	public OrderService()
	{
		// constructor
	}
	
	@GET
	@Produces("application/json")
	public StreamingOutput getOrderJson()
	{
		final Order o = DAOMock.getOrder();

		if (o == null) 
		{
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		
		// return the customer json object
		return new StreamingOutput() 
		{
			public void write( OutputStream outputStream ) throws IOException, WebApplicationException 
			{
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(outputStream, o);
			}
		};
	}

	@GET
	@Produces("application/xml")
	public Order getOrderXml() 
	{
		final Order o = DAOMock.getOrder();

		if (o == null) 
		{
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return o;

	};
	
}
