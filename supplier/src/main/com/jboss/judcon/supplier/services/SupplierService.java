package com.jboss.judcon.supplier.services;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import com.jboss.judcon.supplier.entity.Supplier;
import com.jboss.judcon.supplier.manager.SupplierMgr;

@Name("SupplierService")
@Path("/supplier")
public class SupplierService {

	@Logger
	private Log log;

	@In(create = true, value = "SupplierMgr")
	SupplierMgr supplierMgr;

	@GET
	@Produces("application/xml")
	@Path("{id}")
	public Supplier getSupplierXml(@PathParam("id") int id) {

		log.debug("getSupplierXml()");

		return supplierMgr.getSupplier(id);
	}

	@GET
	@Produces("application/json")
	@Path("{id}")
	public StreamingOutput getSupplierJson(@PathParam("id") int id) {

		log.debug("getSupplierJson()");

		final Supplier supplier = supplierMgr.getSupplier(id);

		if (supplier == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		return new StreamingOutput() {
			public void write(OutputStream outputStream) throws IOException,
					WebApplicationException {
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(outputStream, supplier);
			}

		};
	}
	
	@POST
	@Consumes("application/xml")
	public Response createSupplier(Supplier supplier) {
		Supplier retVal = supplierMgr.create(supplier);
	   log.debug("Created customer " + retVal.getId(), null);
	   return Response.created(URI.create("/customers/"
	                                + supplier.getId())).build();
	}

}