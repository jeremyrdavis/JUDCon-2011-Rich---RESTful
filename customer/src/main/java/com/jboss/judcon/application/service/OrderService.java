package com.jboss.judcon.application.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jboss.judcon.entities.Order;
import com.jboss.judcon.entities.impl.OrderImpl;
import com.jboss.judcon.utilities.DAOMock;

/**
 * REST Order Service, this class does the CRUD operations on an order.
 * 
 * @author Derrick Kittler
 */

@Path("/rest/order")
public class OrderService
{
	private Logger log = LoggerFactory.getLogger(ProduceService.class);
	
	public OrderService()
	{
		super();
	}
	
	/**
	 * @return JSON object for an order
	 */
	@GET
	@Produces("application/json")
	public StreamingOutput getOrderJson()
	{
		final Order o = DAOMock.getOrder();

		if (o == null) 
		{
			throw new WebApplicationException( Response.Status.NOT_FOUND );
		}
		
		return new StreamingOutput() 
		{
			public void write( OutputStream outputStream ) throws IOException, WebApplicationException 
			{
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(outputStream, o);
			}
		};
	}

	/**
	 * @return XML object that represents the order
	 */
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
	
	/**
	 * @return JSON object provided the path parameter is set in the GET
	 */
	@GET
	@Path("{id}")
	@Produces("application/json")
	/**
	 * Return an order given a order id
	 */
	public StreamingOutput getOrderJson( @PathParam("id") int id )
	{
		//TODO this needs to query the data layer to get the order with the provided id
		final Order o = DAOMock.getOrder();

		if( o == null ) 
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
	
	/**
	 * @return Response once an order has been created via POST
	 */
	@POST
	@Consumes("application/json")
	/**
	 * Create a new Order
	 */
	public Response createOrder( InputStream _is )
	{
		JSONParser parser = new JSONParser();
		String orderId = null;
	    String orderName = null;
	    
		try
		{
			@SuppressWarnings("unchecked")
			Map<String,String> oMap= (Map<String,String>)parser.parse( convertStreamToString( _is ) );
			orderId = oMap.get("id").toString();
			orderName = oMap.get("name").toString();
			log.debug("====== Create Order Detail ======");
			log.debug( "This is the id: " + orderId );
			log.debug( "This is the name: " + orderName );
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			log.error( e.toString() );
		}
		catch( IOException ioe )
		{
			log.error( ioe.toString() );
		}		

		Order thisOrder = new OrderImpl( Integer.parseInt( orderId ), orderName ); 

		
		log.debug( "Created order with ID: " + thisOrder.getId() );
		return Response.created( URI.create("/order/" + thisOrder.getId())).build();
	}
	
	
	
	
	@Path("{id}")
	@DELETE
	public void delete( @PathParam("id") int id ) 
	{
		//TODO 
		// delete the order from the database for the given order id
	}

	@PUT
	@Path("{id}")
	@Consumes("application/json")
	public void updateOrder( @PathParam("id") int id, InputStream is )
	{
		// TODO 
	}
	
	/**
	 * Convert an InputStream into a string and return the String
	 * @param is - InputStream
	 * @return String 
	 * @throws IOException
	 */
	private String convertStreamToString(InputStream is) throws IOException
	{
		/*
		 * To convert the InputStream to String we use the Reader.read(char[]
		 * buffer) method. We iterate until the Reader return -1 which means
		 * there's no more data to read. We use the StringWriter class to
		 * produce the string.
		 */
		if (is != null)
		{
			Writer writer = new StringWriter();

			char[] buffer = new char[1024];
			try
			{
				Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1)
				{
					writer.write(buffer, 0, n);
				}
			}
			finally
			{
				is.close();
			}
			log.error("Returning the converted string => " + writer.toString() );
			return writer.toString();
		}
		else
		{
			return "";
		}
	}
	
}
