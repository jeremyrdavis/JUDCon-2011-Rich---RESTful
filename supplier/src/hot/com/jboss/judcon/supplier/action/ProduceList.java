package com.jboss.judcon.supplier.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import com.jboss.judcon.supplier.entity.Produce;

@Name("produceList")
public class ProduceList extends EntityQuery<Produce>
{
    public ProduceList()
    {
        setEjbql("select produce from Produce produce");
    }
}
