/*
 Executing the DML Queries :
 						   1. Insert --> To execute the insert query first we need to create a SQL Query in the form of String
 						   				 in java application.
 						   				 After creating the query we can execute it in 2 ways : execute() & executeUpdate() methods.
 						   		execute() --> It is the nono-static method present in statement.
 						   					  It is a parameterized method it accept DML & DQL both queries as parameter.
 						   					  
 						   					  The return type of execute() method is boolean.
 						   					  It return true if query is DQL type of query(select).
 						   					  It return false if query is DML type of query (insert,update).
 						   					  
 						   		executeUpdate() --> It is a non-static method present in statement .
 						   							It takes only DML Query as an input parameter , if we pass dql it will return Runtime-Exception.
 						   							The return type exectueUpdate() method is integer.
 						   							The integer values indicate number of row i.e., affected in the table due to query.
 */


package Executing_Statement_Object.DML_Execution;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Insert {

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
		
		// executing the dml query 
		// insert
		String insert = "insert into employees values(3,'Shiva',9999999, 9874563201)";
		
		// using execute() method
		boolean b = stm.execute(insert);
		System.out.println(b);
		
		// using executeUpdate() method
		String insert2 = "insert into employees values(2,'gnaseh',111111111, 123456987)";
		int res2 = stm.executeUpdate(insert2);
		if(res2>0) {
			System.out.println("Query Exceuted");
		}
		else {
			System.out.println("Not Executed");
		}
	}

}
