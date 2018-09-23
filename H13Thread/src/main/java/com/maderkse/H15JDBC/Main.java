package com.maderkse.H15JDBC;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Main {
   public static void main(String[] args) throws SQLException {
      System.out.println("Hi, A here!");

      Connection con = DriverManager.getConnection("jdbc:sqlite://home/maderkse/db/F1.db");
      DatabaseMetaData md = con.getMetaData();
      ResultSet rs = md.getTables(null,null,null,null);
      int i=0;
      while (rs.next()) {
         i++;
         String table_name = rs.getString("TABLE_NAME");
         System.out.println(table_name);
         String query = "select * from " + table_name;
         Statement s = con.createStatement();
         ResultSet rsq = s.executeQuery(query);
         ResultSetMetaData rsqm = rsq.getMetaData();
         int cc = rsqm.getColumnCount();
         System.out.println("Aantal kolommen: " + cc);
         while(rsq.next()) {
            for (int c=1;c<=cc;c++) {
               System.out.print(rsq.getString(c));
               if (c!=cc) System.out.print("|");
               else System.out.print("\n");
            }
         }
      }
   }
}
