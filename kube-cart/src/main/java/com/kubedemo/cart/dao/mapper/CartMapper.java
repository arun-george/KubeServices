package com.kubedemo.cart.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.kubedemo.cart.domain.Cart;

public class CartMapper implements ResultSetMapper<Cart>{

	public Cart map(int arg0, ResultSet resultset, StatementContext statementContext) throws SQLException {
		Cart cart = new Cart();
		cart.setId(resultset.getString("cart_id"));
		cart.setProductId(resultset.getString("product_id"));
		return cart;
	}

}
