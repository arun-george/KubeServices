package com.kubedemo.catalog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.kubedemo.catalog.domain.Product;

public class ProductMapper implements ResultSetMapper<Product>{

	@Override
	public Product map(int arg0, ResultSet resultSet, StatementContext statementContext) throws SQLException {
		Product prod = new Product(resultSet.getString("name"),resultSet.getString("description"));
		return prod;
 	}

}
