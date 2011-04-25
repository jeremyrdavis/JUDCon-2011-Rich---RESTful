package com.jboss.judcon.supplier.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "suppliers")
@XmlSeeAlso(Supplier.class)
public class SupplierList {

	private List<Supplier> suppliers;

	public SupplierList() {
	}

	public SupplierList(List<Supplier> list) {
		this.suppliers = list;
	}

	@XmlElement(name = "Item")
	public List<Supplier> getList() {
		return suppliers;
	}

}
