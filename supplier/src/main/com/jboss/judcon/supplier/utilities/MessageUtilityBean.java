package com.jboss.judcon.supplier.utilities;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

@Stateless
@Name("MessageUtility")
public class MessageUtilityBean implements MessageUtility {

    @Logger private Log log;

	@Override
	public String getDefaultMessage() {
		log.debug("MessageUtilityBean says, 'Hi!'", null);
		return "Hi, there";
	}

}
