package com.jboss.judcon.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierImpl implements Supplier{
	
	@XmlAttribute
	int id;
	
	@XmlElement
	String name;

	public SupplierImpl() {
	}

	public SupplierImpl(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
