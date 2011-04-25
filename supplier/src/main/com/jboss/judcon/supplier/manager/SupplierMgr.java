package com.jboss.judcon.supplier.manager;

import java.util.List;

import javax.ejb.Local;

import com.jboss.judcon.supplier.entity.Supplier;

@Local
public interface SupplierMgr {

	public List<Supplier> getSuppliers();

	public Supplier getSupplier(int id);

	public Supplier create(Supplier supplier);
}
