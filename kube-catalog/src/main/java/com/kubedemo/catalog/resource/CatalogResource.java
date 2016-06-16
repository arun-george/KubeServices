package com.kubedemo.catalog.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.kubedemo.catalog.dao.ProductDao;
import com.kubedemo.catalog.domain.Product;

@Path("/catalog")
public class CatalogResource {

	Logger logger = LoggerFactory.getLogger(CatalogResource.class);
	ProductDao productDao;
	
	public CatalogResource(ProductDao productDao){
		this.productDao=productDao;
	}
	
	private static final String JCP_ENVIRONMENT = "prod";

	@GET
	@Timed
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getCatalog() {
		return productDao.getAll();
		//return null;
	}

	@POST
	@Timed
	@Path("/log")
	@Consumes(MediaType.TEXT_PLAIN)
	public void log(String str) {
		System.out.println("success!");
		System.out.println("\n\n----------------------------------");
		System.out.println(str);
		System.out.println("\n\nEnd-------------------------------");
	}

}
