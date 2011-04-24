package com.jboss.judcon.supplier.utilities;

import javax.ejb.Local;

@Local
public interface MessageUtility {

	public String getDefaultMessage();
}
