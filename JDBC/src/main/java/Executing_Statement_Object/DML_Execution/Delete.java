package Executing_Statement_Object.DML_Execution;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Delete {

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
		
//		using execute method
		String delete = "delete from employees where id = 1";
		boolean result = stm.execute(delete);
		System.out.println(result);
		
		//using executeUpdate method
		String delete1 = "delete from employees where id=3";
		int result1 = stm.executeUpdate(delete1);
		System.out.println(result1);
		if(result1>0) {
			System.out.println("Query executed successfully");
		}
		else {
			System.out.println("Failed to execute");
		}
	}
	

}
