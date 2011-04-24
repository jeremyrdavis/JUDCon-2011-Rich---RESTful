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

import com.jboss.judcon.entities.Produce;
import com.jboss.judcon.utilities.DAOMock;


@Path("/produce")
public class ProduceService
{
	private Logger log = LoggerFactory.getLogger(ProduceService.class);
	public ProduceService()
	{
		// constructor
	}
	
	@GET
	@Produces("application/json")
	public StreamingOutput getProduceJson()
	{
		final Produce p = DAOMock.getProduce();

		if (p == null) 
		{
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		
		// return the customer json object
		return new StreamingOutput() 
		{
			public void write( OutputStream outputStream ) throws IOException, WebApplicationException 
			{
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(outputStream, p);
			}
		};
	}
	
	@GET
	@Path("/fruits")
	@Produces("application/json")
	public StreamingOutput getFruitJson()
	{
		final Produce fruit = DAOMock.getFruit();
		
		if( fruit == null ) 
		{
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		
		// return the customer json object
		return new StreamingOutput() 
		{
			public void write( OutputStream outputStream ) throws IOException, WebApplicationException 
			{
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(outputStream, fruit);
			}
		};
	}

	@GET
	@Path("/vegetable")
	@Produces("application/json")
	public StreamingOutput getVegetableJson()
	{
		final Produce vegetable = DAOMock.getFruit();
		
		if( vegetable == null ) 
		{
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		
		// return the customer json object
		return new StreamingOutput() 
		{
			public void write( OutputStream outputStream ) throws IOException, WebApplicationException 
			{
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(outputStream, vegetable);
			}
		};
	}	
	
	@GET
	@Produces("application/xml")
	public Produce getProduceXml() 
	{
		final Produce p = DAOMock.getProduce();

		if (p == null) 
		{
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return p;

	};
	
}
