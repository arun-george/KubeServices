package com.kubedemo.cart.domain;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cart {

	@NotNull
	@JsonProperty
	String id;
	
	@NotNull
	@JsonProperty
	String productId;
	
	public Cart(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Cart(String id, String productId) {
		super();
		this.id = id;
		this.productId = productId;
	}

}
