package com.kubedemo.catalog.domain;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	
	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@NotNull
	@JsonProperty
	private String name;
	
	@NotNull
	@JsonProperty
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
