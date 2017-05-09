package com.jersey.model;


import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DatabaseConnection {
	private static DataSource dataSource;
	
	static{
		try{
			dataSource = (DataSource) new InitialContext().lookup("jdbc:sqlserver://localhost;databaseName=PC1964;integratedSecurity=true;");
		}catch (NamingException e){
			throw new ExceptionInInitializerError("DB not found");
		}
	}
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
