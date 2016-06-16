package com.kubedemo.cart.config;

import org.skife.jdbi.v2.DBI;

import com.kubedemo.cart.dao.CartDao;
import com.kubedemo.cart.resource.CartResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

public class CartApplication extends Application<CartConfiguration> {

	private static final String CONFIG_LOC = "D:\\proposals\\2016\\KubeDemo\\catalog\\src\\main\\resources\\config.yml";

	public static void main(String[] args) throws Exception {
		new CartApplication().run(new String[] { "server", CONFIG_LOC });
	}

	@Override
	public void run(CartConfiguration conf, Environment env) throws Exception {
		// MetricRegistry registry = env.metrics();
		// registry.name(Queue.class, "requests", "size");

		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(env, conf.getDataSourceFactory(), "mysql");

		final CartDao cartDao = jdbi.onDemand(CartDao.class);
		final CartResource catalogResource = new CartResource(cartDao);

		env.jersey().register(catalogResource);
		env.healthChecks().register("cmhealth", new CartHealthCheck());

	}


}
