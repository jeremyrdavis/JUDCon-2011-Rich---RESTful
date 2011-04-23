package com.jboss.judcon.supplier.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import com.jboss.judcon.supplier.entity.Vegetable;

@Name("vegetableList")
public class VegetableList extends EntityQuery<Vegetable>
{
    public VegetableList()
    {
        setEjbql("select vegetable from Vegetable vegetable");
    }
}
