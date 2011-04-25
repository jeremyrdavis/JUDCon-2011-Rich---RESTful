package com.jboss.judcon.supplier.manager;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import com.jboss.judcon.supplier.entity.Supplier;

@Stateless
@Name("SupplierMgr")
public class SupplierMgrImpl implements SupplierMgr {

    @Logger private Log log;

    @Override
	public List<Supplier> getSuppliers() {
		log.debug("getSuppliers()");
    	return mockSuppliers(5);
	}

	private List<Supplier> mockSuppliers(int count) {
		List<Supplier> retVal = new ArrayList<Supplier>(5);
		for(int i = 0; i < count; i++){
			retVal.add(new Supplier(i, "Supplier #" + i));
		}
		return retVal;
	}

	@Override
	public Supplier getSupplier(int id) {
		return mockSuppliers(1).get(0);
	}

	@Override
	public Supplier create(Supplier supplier) {
		supplier.setId(101);
		return supplier;
	}

}
