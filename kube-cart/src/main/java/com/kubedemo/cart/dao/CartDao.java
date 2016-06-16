package com.kubedemo.cart.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.kubedemo.cart.dao.mapper.CartMapper;
import com.kubedemo.cart.domain.Cart;

@RegisterMapper(CartMapper.class)
public interface CartDao {

	@SqlQuery("select * from cart where cart_id= :id")
	public Cart findCartById(@Bind("id") String cartid);

	@SqlUpdate("insert into cart(cart_id, product_id, status) values(:cartid, :productid, 'pending')")
	public void insert(@Bind("cartid")int cartid, @Bind("productid") int productid);

}
