package com.jboss.judcon.entities.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jboss.judcon.entities.Customer;


@XmlRootElement(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerImpl implements Customer
{
	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return this.name;
	}
	
	@XmlAttribute
	int id;
	
	@XmlElement
	String name;

	public CustomerImpl()
	{
	}

	public CustomerImpl(int id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
