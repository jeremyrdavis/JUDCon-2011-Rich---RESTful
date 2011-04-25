package com.jboss.judcon.supplier.services;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import com.jboss.judcon.supplier.entity.Supplier;
import com.jboss.judcon.supplier.entity.SupplierList;
import com.jboss.judcon.supplier.manager.SupplierMgr;
import com.jboss.judcon.supplier.utilities.MessageUtility;

@Name("SuppliersService")
@Path("/suppliers")
public class SuppliersService {
	@Logger
	private Log log;

	@In(create = true, value = "MessageUtility")
	MessageUtility messageUtility;

	@In(create = true, value = "SupplierMgr")
	SupplierMgr supplierMgr;

	@XmlElement(name = "suppliers")
	List<Supplier> suppliers;

	@GET
	@Produces("application/xml")
	public SupplierList getSuppliersXml() {

		log.debug("getSupplierXml()");

		return new SupplierList(supplierMgr.getSuppliers());
	}

	@GET
	@Produces("application/json")
	public StreamingOutput getSupplierJson() {

		log.debug("getSupplierJson()");

		final List<Supplier> suppliers = supplierMgr.getSuppliers();

		if (suppliers == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}

		return new StreamingOutput() {
			public void write(OutputStream outputStream) throws IOException,
					WebApplicationException {
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(outputStream, suppliers);
			}

		};
	}

}
