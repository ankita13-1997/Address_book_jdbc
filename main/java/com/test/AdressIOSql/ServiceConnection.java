package com.test.AdressIOSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceConnection {
	
	static Connection conneection;
	static Statement statement;
	static String jdbcUrl="jdbc:mysql://localhost:3306/addressbook?useSSL=false";
	static String username="root";
	static String password="Ankita@9713";
	
	public static Connection getConnection() {
		
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			System.out.println("Connecting to database "+jdbcUrl);
			conneection=DriverManager.getConnection(jdbcUrl,username,password);
			System.out.println("don!!!");
			
			
		    }
		catch(ClassNotFoundException | SQLException  e)
		{
			//throw new IllegalStateException("cannot find driver");
			e.printStackTrace();
		}
		
		  return conneection;
	}
	

}
