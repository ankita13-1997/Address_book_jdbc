package com.test.AdressIOSql;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

public class Adress_Test {

	@Test
	public void printRecordsFromDBtest() throws SQLException
	{
         AdressBookServices services = new AdressBookServices();
         services.print();
    }
	
	@Test
	public void InsertRecordsFromDBtest() throws SQLException, ClassNotFoundException, IOException
	{
         AdressBookServices services = new AdressBookServices();
         services.add_new();
    }
	
	@Test
	public void DeleteRecordsFromDBtest() throws SQLException, ClassNotFoundException, IOException
	{
         AdressBookServices services = new AdressBookServices();
         services.delete();
    }
	
	@Test
	public void UpdateRecordsFromDBtest() throws SQLException, ClassNotFoundException, IOException
	{
         AdressBookServices services = new AdressBookServices();
         services.update();
    }
	
}
