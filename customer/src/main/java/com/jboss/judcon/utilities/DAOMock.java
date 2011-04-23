package com.jboss.judcon.utilities;

import java.util.List;

import com.jboss.judcon.entities.Supplier;
import com.jboss.judcon.entities.SupplierImpl;

public class DAOMock {

	public static List<Supplier> getAllSuppliers() {
		return null;
	}

	public static Supplier getSupplier() {
		return new SupplierImpl(1, "Supplier #1");
	}

}
