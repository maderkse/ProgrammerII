package com.maderkse.H15JDBC;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.maderkse.F1.Drivers;
class Main {
	public static void main(String[] args) {
		System.out.println("Hi");
		Drivers drivers = null;
		Connection conn = null;

		System.out.println("dbUrl: " + System.getProperty("dbUrl"));

		String dbUrl = System.getProperty("dbUrl");

		if (dbUrl == null) {
			System.out.println("Missing -DdbUrl option.");
			System.exit(1);
		}

		try{
			conn = DriverManager.getConnection(dbUrl);

		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}

		drivers  = new Drivers(conn);

	}
}
