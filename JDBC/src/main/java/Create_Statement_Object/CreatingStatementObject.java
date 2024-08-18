/*
 Creating Statement Object :
 						   * To create the statement object we need to make use of an interface called statement.
 						   * Since statement is an interface so direct object creation is not possible.
 						   * we need to help of createStatement() method which is present in Connection.
 						   * createStatement() is non-static method it creates the object of the the implemented class which 
 						     implements statement interface present in JBDC interface , it returns the statement type object.
 						     
 						      
 */

package Create_Statement_Object;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreatingStatementObject {

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
	}
}
