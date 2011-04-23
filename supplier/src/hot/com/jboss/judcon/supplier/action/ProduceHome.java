package com.jboss.judcon.supplier.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.jboss.judcon.supplier.entity.Produce;

@Name("produceHome")
public class ProduceHome extends EntityHome<Produce>
{
    @RequestParameter Long produceId;

    @Override
    public Object getId()
    {
        if (produceId == null)
        {
            return super.getId();
        }
        else
        {
            return produceId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
