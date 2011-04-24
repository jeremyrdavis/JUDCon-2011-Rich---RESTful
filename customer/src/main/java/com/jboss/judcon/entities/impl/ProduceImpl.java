package com.jboss.judcon.entities.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jboss.judcon.entities.Produce;

@XmlRootElement(name="produce")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProduceImpl implements Produce
{
	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return this.name;
	}
	
	@XmlAttribute
	private int id;
	
	@XmlElement
	private String name;

	@XmlAttribute
	private String typeName;
	
	private ProduceType produceType;
	
	public ProduceImpl()
	{
	}

	public ProduceImpl(int id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	public ProduceImpl(int id, String name, ProduceType type)
	{
		super();
		this.id = id;
		this.name = name;
		this.produceType = type;
		
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

	public ProduceType getProduceType()
	{
		return this.produceType;
	}

	public void setType(ProduceType type)
	{
		this.produceType = type;
	}	

	
	
}
