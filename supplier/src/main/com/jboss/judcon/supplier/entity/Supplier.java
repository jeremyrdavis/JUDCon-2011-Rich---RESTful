package com.jboss.judcon.supplier.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.Length;

@Entity
@Table(name = "supplier")
@XmlRootElement(name="supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class Supplier implements Serializable {

	private static final long serialVersionUID = -2777750679855439742L;
	
	@XmlAttribute
	private int id;
	
	@XmlElement
	private Integer version;
	
	@XmlElement
	private String name;

	public Supplier() {
		super();
	}
	
	public Supplier(int idToSet, String nameToSet){
		this.id = idToSet;
		this.name = nameToSet;
	}

	@Id
	@GeneratedValue
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
