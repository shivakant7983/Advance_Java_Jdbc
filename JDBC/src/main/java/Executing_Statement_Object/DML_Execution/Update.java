package Executing_Statement_Object.DML_Execution;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Update {
	
public static void main(String[] args) throws ClassNotFoundException,IOException, SQLException {
		
		// load the driver
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver Loaded");
		
		// establish the connection
		
		FileInputStream fis = new FileInputStream("config.properties");
		
		Properties property = new Properties();
		property.load(fis);
		
		String url = property.getProperty("url");
		
		Connection con = DriverManager.getConnection(url, property);
		
		System.out.println("Connetion Establish Sucessfully");
		
		// create statement object
		
		Statement stm = con.createStatement();
		System.out.println("Statement Object Created");
		
		
		// update
		// using execute() method
		
		String update = "update employees set name = 'Shiv' where id = 1";
		boolean res = stm.execute(update);
		System.out.println(res);
		
		
		// using executeUpdate() method 
		
		String update2 = "update employees set number = 5641338972 , name = 'gnaseh' where id = 2";
		int res2 = stm.executeUpdate(update2);
		System.out.println(res2);
		if(res2>0)
			System.out.println("Query update suceesfully");
		else
			System.out.println("Not updated");
	}
}
