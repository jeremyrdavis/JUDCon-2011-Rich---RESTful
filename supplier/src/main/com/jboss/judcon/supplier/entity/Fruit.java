package com.jboss.judcon.supplier.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="FRUIT")
public class Fruit extends Produce
{

	private static final long serialVersionUID = -7416562253334968405L;

	public Fruit() {
		super();
	}
	
	

}
