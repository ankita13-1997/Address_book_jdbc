package com.test.AdressIOSql;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;




public class AddressBookDb {
	
	static Scanner sc= new Scanner(System.in);
	static List<Book> bookStore= new ArrayList<>();
	static boolean exit=false;
	static Connection conneection;
	static Statement statement;
	
	
	 
	
	
	
	 public static List<Book> display() throws SQLException
	  { 
		 
		  
		
		  try 
		  {
			    
                conneection=ServiceConnection.getConnection();
			    statement= conneection.createStatement();
				ResultSet result = statement.executeQuery("select * from book");
			    while(result.next())
				{
				  Book b= new Book();
				  b.setId(result.getInt(1));
				  b.setFirstname(result.getString(2));
				  b.setLastname(result.getString(3));
				  b.setTypename(result.getString(4));
				  b.setState(result.getString(5));
				  b.setCity(result.getString(6));
				  b.setZip_code(result.getString(7));
				  b.setPhone_no(result.getString(8));
				  b.setEmail(result.getString(9));
				  
				  bookStore.add(b);
				  
				  
				}
			  conneection.close();
			  System.out.println("your address book represents");
			  
			}
		  
		  catch (SQLException e) {
			   e.printStackTrace();
				}
		return bookStore;
		
		
		  
			  
	  }
	 
	 public static int insertValues() throws SQLException, ClassNotFoundException, IOException 
		{
		PreparedStatement statement1;
		int i = 0;
			 
			 try {
			 System.out.println("inserting into the table ");
			 conneection=ServiceConnection.getConnection();
			 statement1= conneection.prepareStatement("insert into book(first_name,last_name,type_name,state,city,zip_code,phone_no,email)"
			 		+ "              value(?,?,?,?,?,?,?,?)");
			 
			
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			   do {
				   
				   System.out.println("enter the first_name");
				   String first_name= br.readLine();
				   System.out.println("enter the last_name ");
				   String last_name =br.readLine();
				   System.out.println("enter the type_name ");
				   String type_name =br.readLine();
				   System.out.println("enter the state");
				   String state= br.readLine();
				   System.out.println("enter the city");
				   String city = br.readLine();
				   System.out.println("enter zip_code");
				   String zip_code=br.readLine();
				   System.out.println("enter phone number ");
				   String phone_no= br.readLine();
				   System.out.println("enter email ");
				   String email= br.readLine();
				  
				   
				   
				   statement1.setString(1, first_name);
				   statement1.setString(2, last_name);
				   statement1.setString(3, type_name);
				   statement1.setString(4, state);
				   statement1.setString(5, city);
				   statement1.setString(6, zip_code);
				   statement1.setString(7, phone_no);
				   statement1.setString(8, email);
				   
				    i = statement1.executeUpdate();
			   
			   System.out.println();
			   System.out.println("inserted sucessfully " +i+ "rows affected\n");
			   
			   System.out.println("do you want to continue Y[yes]/N[no]");
			   
			   String option = br.readLine();
			   if(option.startsWith("N"))
			   {
				   break;
			   }
			   
			   System.out.println("--------------------------------------------------------------------------------------------");
			 }
			   while(true);
			   
			 
			 }
			 
			 catch(SQLException  e)
				{
					//throw new IllegalStateException("cannot find driver");
					e.printStackTrace();
				}
			
			conneection.close();
			return i; 
		}
	 

	 
	 public static void  DeleteContent() throws SQLException, NumberFormatException, IOException
	 {
		 PreparedStatement statement1;
		
		 try 
		 {
			conneection=ServiceConnection.getConnection();
		   System.out.println("Alteration  of Table");
		  
		  
		   //String sql ="DELETE from employee_system where id=?";
		   statement1=conneection.prepareStatement("DELETE from book where first_name=?");
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  
		   System.out.println("enter the first name");
		  
		   String first_name=br.readLine();
		   
		   statement1.setString(1, first_name);
		   int i= statement1.executeUpdate();
		  
		   if(i > 0) {
		   System.out.println(i+ " contains deleted  from table");
		   System.out.println("----------------------------------------------------------------------------------");
		   }
		   
		   else
		   {
			   System.out.println("the content is already not presnt in table");
			   System.out.println("----------------------------------------------------------------------------------");
		   }	
		   conneection.close();
		 }
		 catch (SQLException e) {
			// TODO: handle exception
			 e.printStackTrace();
		} 
		 
		 
	 }
	 
	 
	 public static void updateValues() throws SQLException, IOException
		{
		 PreparedStatement statement1 = null;
		
			
			try 
			{
				conneection=ServiceConnection.getConnection();
				System.out.println("updating in table");
				 String  sql =" UPDATE book set zip_code=? where first_name=?";
				statement1=conneection.prepareStatement(sql);
				   
				//String sql = "UPDATE  employee_system set salary='230000' where name='katta';";
	            //statement.executeUpdate(sql);
				 
				 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			    System.out.println("enter the zip_code");
		        String zip_code=br.readLine();
	            System.out.println("enter the first name");
	            String first_name= br.readLine();
	            
	            statement1.setString(1, zip_code);
	            statement1.setString(2, first_name);
				int i=statement1.executeUpdate();
	            
				if(i >0) {
	            System.out.println();
	            System.out.println(i+" updated successfully");
	            System.out.println("-------------------------------------------------------------------------------------");
				}
				else
				{
					System.out.println("given data is incorrect");
				}
				
				conneection.close();
			}
			
			catch(SQLException  e)
			{
				//throw new IllegalStateException("cannot find driver");
				e.printStackTrace();
			}
			
			
		}	
	 
}
