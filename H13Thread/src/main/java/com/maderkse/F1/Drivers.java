package com.maderkse.F1;

import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Drivers {

	private Connection conn;


	public Drivers(Connection conn){
		System.out.println("Hi, Drivers here!");
		this.conn = conn;
		this.init();
	}


	public static void main(String[] args) {
                System.out.println("Hi");
                Drivers drivers = null;                               Connection conn = null;
                                                                      System.out.println("dbUrl: " + System.getProperty("dbUrl"));                                                                                                      String dbUrl = System.getProperty("dbUrl");                                                                                                                       if (dbUrl == null) {
                        System.out.println("Missing -DdbUrl option.");                                                              System.exit(1);                               }                                     
                try{
                        conn = DriverManager.getConnection(dbUrl);

                } catch(SQLException e) {
                        System.out.println(e.getMessage());
                }

                drivers  = new Drivers(conn);

        }

	public void init() {
		DatabaseMetaData dbm;
		ResultSet rs;
	        try {
			dbm = this.conn.getMetaData();
			rs = dbm.getTables(null,null,"drivers",null);
			if (rs.next()){
				System.out.println("Table drivers bestaat.");
			} else {
				System.out.println("Table drivers bestaat niet.");
				this.createDrivers();
			}	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createDrivers() {
		String ddl = "create table drivers ( " +
			     "first_name VARCHAR(255)," +
			     "last_name VARCHAR(255)," +
			     "start_nr INTEGER)";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(ddl);
			System.out.println("Table drivers is aangemaakt.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			}	
		}
	}
}
