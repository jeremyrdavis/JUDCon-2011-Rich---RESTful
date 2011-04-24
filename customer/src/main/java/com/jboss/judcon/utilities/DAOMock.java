package com.jboss.judcon.utilities;

import java.util.List;

import com.jboss.judcon.entities.Customer;
import com.jboss.judcon.entities.Order;
import com.jboss.judcon.entities.Produce;
import com.jboss.judcon.entities.Supplier;
import com.jboss.judcon.entities.impl.CustomerImpl;
import com.jboss.judcon.entities.impl.FruitImpl;
import com.jboss.judcon.entities.impl.OrderImpl;
import com.jboss.judcon.entities.impl.ProduceImpl;
import com.jboss.judcon.entities.impl.SupplierImpl;
import com.jboss.judcon.entities.impl.VegetableImpl;

public class DAOMock {

	public static List<Supplier> getAllSuppliers() {
		return null;
	}

	public static Supplier getSupplier() {
		return new SupplierImpl(1, "Supplier #1");
	}

	/**
	 * 
	 * @return Customer - create a synthetic customer and return
	 */
	public static Customer getCustomer()
	{
		return new CustomerImpl(1, "CustmerFoo");
	}
	
	
	public static Produce getProduce()
	{
		return new ProduceImpl(1, "Vegetables");
	}
	
	public static Order getOrder()
	{
		return new OrderImpl(1, "First Order");
	}
	
	public static Produce getFruit()
	{
		return  new ProduceImpl(1, "apple", new FruitImpl());
	}
	
	public static Produce getVegetable()
	{
		return new ProduceImpl(1, "carrot", new VegetableImpl());
	}
}
