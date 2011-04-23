package com.jboss.judcon.supplier.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.jboss.judcon.supplier.entity.Supplier;

@Name("supplierHome")
public class SupplierHome extends EntityHome<Supplier>
{
    @RequestParameter Long supplierId;

    @Override
    public Object getId()
    {
        if (supplierId == null)
        {
            return super.getId();
        }
        else
        {
            return supplierId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
