package com.kubedemo.cart.config;

import com.codahale.metrics.health.HealthCheck;

public class CartHealthCheck extends HealthCheck {

	@Override
	protected Result check() throws Exception {
		return Result.healthy("all good");
	}

}
