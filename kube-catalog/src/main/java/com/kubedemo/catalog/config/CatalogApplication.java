package com.kubedemo.catalog.config;

import java.util.Queue;

import org.skife.jdbi.v2.DBI;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

import com.codahale.metrics.MetricRegistry;
import com.kubedemo.catalog.dao.ProductDao;
import com.kubedemo.catalog.resource.CatalogResource;

public class CatalogApplication extends Application<CatalogConfiguration> {
	
	private static final String CONFIG_LOC="D:\\proposals\\2016\\KubeDemo\\catalog\\src\\main\\resources\\config.yml";

	public static void main(String[] args) throws Exception {
		new CatalogApplication().run(new String[] { "server", CONFIG_LOC });
	}

	@Override
	public void run(CatalogConfiguration conf, Environment env) throws Exception {
		//MetricRegistry registry = env.metrics();
		//registry.name(Queue.class, "requests", "size");

		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(env, conf.getDataSourceFactory(), "mysql");

		final ProductDao productDao = jdbi.onDemand(ProductDao.class);
		final CatalogResource catalogResource = new CatalogResource(productDao);

		env.jersey().register(catalogResource);
		env.healthChecks().register("cmhealth", new CatalogHealthCheck());

	}

	/**
	 * @Override public void run(CmdbConfiguration cconf, Environment env)
	 *           throws Exception { final CmdbResource cmdbres = new
	 *           CmdbResource(); env.jersey().register(cmdbres);
	 * 
	 *           final CmdbConfigurationCheck ccheck = new
	 *           CmdbConfigurationCheck(cconf.getVersion());
	 *           env.healthChecks().register("cmdb", ccheck);
	 *           env.jersey().register(ccheck);
	 * 
	 *           }
	 * 
	 */

}
