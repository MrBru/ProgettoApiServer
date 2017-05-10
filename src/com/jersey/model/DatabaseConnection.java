package com.jersey.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnection {
	public static Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
		try {
			System.out.println("inizio connessione");
			// the sql server driver string
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// the sql server url
			String url = "jdbc:sqlserver://PC1964:1433;DatabaseName=project_work";

			// get the sql server database connection
			connection = DriverManager.getConnection(url, "sa", "qwerty1234");

			// now do whatever you want to do with the connection
			// ...
			System.out.println("fine connessione");

		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(2);
		}
		return connection;
	}
}
