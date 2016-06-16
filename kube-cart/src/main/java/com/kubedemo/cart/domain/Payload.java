package com.kubedemo.cart.domain;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

public class Payload {
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this.getClass())
			.add("cartid", this.cartid)
			.add("productid", productid)
			.toString();
		//return "Payload [cartid=" + cartid + ", productid=" + productid + "]";
	}

	@NotNull
	@JsonProperty
	private int cartid;
	
	@NotNull
	@JsonProperty
	private int productid;

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

}
