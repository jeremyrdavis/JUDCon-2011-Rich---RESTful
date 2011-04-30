package com.jboss.judcon.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.jboss.judcon.application.service.CustomerService;
import com.jboss.judcon.application.service.OrderService;
import com.jboss.judcon.application.service.ProduceService;
import com.jboss.judcon.application.service.SupplierService;


public class CustomerApplication extends Application
{

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public CustomerApplication()
	{
		singletons.add( new SupplierService() );
		singletons.add( new OrderService()    );
		singletons.add( new CustomerService() );
		singletons.add( new ProduceService()  );	
	}

	@Override
	public Set<Class<?>> getClasses()
	{
		// TODO Auto-generated method stub
		return empty;
	}

	@Override
	public Set<Object> getSingletons()
	{
		return singletons;
	}

}
