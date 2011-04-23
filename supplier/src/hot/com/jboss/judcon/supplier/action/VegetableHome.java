package com.jboss.judcon.supplier.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.jboss.judcon.supplier.entity.Vegetable;

@Name("vegetableHome")
public class VegetableHome extends EntityHome<Vegetable>
{
    @RequestParameter Long vegetableId;

    @Override
    public Object getId()
    {
        if (vegetableId == null)
        {
            return super.getId();
        }
        else
        {
            return vegetableId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
