package com.kubedemo.catalog.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.kubedemo.catalog.domain.Product;
import com.kubedemo.catalog.mapper.ProductMapper;

@RegisterMapper(ProductMapper.class)
public interface ProductDao {

	@SqlQuery("select * from product")
	List<Product> getAll();

}
