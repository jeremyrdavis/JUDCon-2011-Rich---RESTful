package com.jboss.judcon.supplier.action;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import com.jboss.judcon.supplier.entity.Fruit;

@Name("fruitList")
public class FruitList extends EntityQuery<Fruit>
{
    public FruitList()
    {
        setEjbql("select fruit from Fruit fruit");
    }
}
