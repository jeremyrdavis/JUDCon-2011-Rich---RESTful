package com.jboss.judcon.supplier.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.jboss.judcon.supplier.entity.Fruit;

@Name("fruitHome")
public class FruitHome extends EntityHome<Fruit>
{
    @RequestParameter Long fruitId;

    @Override
    public Object getId()
    {
        if (fruitId == null)
        {
            return super.getId();
        }
        else
        {
            return fruitId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
