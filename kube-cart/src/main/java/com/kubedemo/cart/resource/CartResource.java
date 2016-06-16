package com.kubedemo.cart.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.kubedemo.cart.dao.CartDao;
import com.kubedemo.cart.domain.Cart;
import com.kubedemo.cart.domain.Payload;
import com.kubedemo.catalog.domain.Product;

@Path("/cart")
public class CartResource {
	
	private CartDao dao;

	public CartResource(CartDao dao) {
		super();
		this.dao = dao;
	}
	
	@GET
	@Timed
	@Path("/{cartid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cart getCartContents(@PathParam("cartid") String cartId){
		return dao.findCartById(cartId);
	}
	
	@POST
	@Timed
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addToCart(Payload payload){
		//System.out.println(payload.toString());
		dao.insert(payload.getCartid(), payload.getProductid());
		//return Response.status(201).entity("success").build();
	}

}
