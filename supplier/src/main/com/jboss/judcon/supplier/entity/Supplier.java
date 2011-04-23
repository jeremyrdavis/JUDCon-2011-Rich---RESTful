package com.jboss.judcon.supplier.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.validator.Length;

@Entity
@Table(name="supplier")
public class Supplier implements Serializable
{
	private int id;
    private Integer version;
    private String name;

    
    public Supplier() {
		super();
	}

	@Id @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    public Integer getVersion() {
        return version;
    }

    private void setVersion(Integer version) {
        this.version = version;
    }

    @Length(max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
