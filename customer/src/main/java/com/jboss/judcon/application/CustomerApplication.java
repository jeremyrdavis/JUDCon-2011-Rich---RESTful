package com.jboss.judcon.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class CustomerApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
