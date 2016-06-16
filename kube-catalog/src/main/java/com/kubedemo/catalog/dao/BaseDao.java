package com.kubedemo.catalog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://10.140.100.109:3306/jcpcmdb", "root", "Welcome!23");
		//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jcpcmdb", "root", "");
		return connection;
	}

}
