package com.kubedemo.catalog.config;

import com.codahale.metrics.health.HealthCheck;

public class CatalogHealthCheck extends HealthCheck {

	@Override
	protected Result check() throws Exception {
		return Result.healthy("all good");
	}

}
