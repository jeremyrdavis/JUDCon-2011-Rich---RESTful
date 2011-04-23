package com.jboss.judcon.supplier.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(name="produce")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="produce_type", discriminatorType=DiscriminatorType.STRING)
public abstract class Produce implements Serializable
{
    private int id;
    private Integer version;
    private String name;
    private String description;

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

    @NotNull @Length(max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(max=250)
    public String getDescription(){
    	return this.description;
    }
    
    public void setDescription(String descriptionToSet){
    	this.description = descriptionToSet;
    }
}
