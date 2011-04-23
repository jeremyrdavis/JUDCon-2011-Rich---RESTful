package com.jboss.judcon.supplier.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="VEGETABLE")
public class Vegetable extends Produce
{

	private static final long serialVersionUID = 3567919277689532169L;

	public Vegetable() {
		super();
	}
	
	
}
