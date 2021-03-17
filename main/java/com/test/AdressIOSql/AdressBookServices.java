package com.test.AdressIOSql;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;



public class AdressBookServices {
	Scanner sc = new Scanner(System.in);
	 static boolean exit = false;

	 
	 public void print() throws SQLException 
	 
	    {
			// TODO Auto-generated method stub
			System.out.println(AddressBookDb.display().toString());
		}
	 
	public void add_new() throws ClassNotFoundException, SQLException, IOException {
			System.out.println(AddressBookDb.insertValues());
			
		}
	
	public void delete() throws NumberFormatException, SQLException, IOException {
		// TODO Auto-generated method stub
		AddressBookDb.DeleteContent();
	}
	
	
	public void update() throws SQLException, IOException {
		// TODO Auto-generated method stub
		AddressBookDb.updateValues();
		
	}
	 
	 static void end()
     {
         	System.out.println("thank you");
			exit=true;
     }
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		while (!exit) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1. for adding contact");
			System.out.println("2.displaying");
			System.out.println("3.updating the addrss book");
			System.out.println("4.for data removal");
			System.out.println("5.For Exit");
			System.out.println("choose your option");
			int userin = sc.nextInt();
			switch (userin) {
			case 1:
				new AdressBookServices().add_new();
				break;

			case 2:

				new AdressBookServices().print();
				break;

			case 3:
				new AdressBookServices().update();
				break;

			case 4:
				new AdressBookServices().delete();
				break;

			case 5:
				end();
				break;

			}


	}

}

	

	


	
}	
	
