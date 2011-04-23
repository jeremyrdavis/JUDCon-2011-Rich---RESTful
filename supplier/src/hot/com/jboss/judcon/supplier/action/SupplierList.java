package com.jboss.judcon.supplier.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import com.jboss.judcon.supplier.entity.Supplier;

@Name("supplierList")
public class SupplierList extends EntityQuery<Supplier>
{
    public SupplierList()
    {
        setEjbql("select supplier from Supplier supplier");
    }
}
