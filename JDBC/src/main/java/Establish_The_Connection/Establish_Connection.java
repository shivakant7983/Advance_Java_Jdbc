/*
  Establish the connection :
  							* To establish the connection we need to make use of the connection interface.
  							*  The connection interface is present in JDBC the fully qualified name is java.sql.connetion
  							*  As it is an interface , the direct object creation is not possible , so we need to make 
  							   use of getConnection method which is present in Driver Manager.
  	
  	Get_Connetion method --->
  	 						1. getConnection(url,user,password);
  	 						2. getConnection(url);
  	 						3. getConnetion(url,properties);
  	 						
  	 				url --> From JDBC to which database we want to connect i.e. postgre , mysql etc.
  	 						It indicate what is the prot number of the particular DB server .
  	 							postgre's --> 5432
  	 							MySql --> 3306
  	 							
  	 				user ---> The user indicate user name which is present in the database.
  	 						  In the DB there can be multiple user , so in this case the postgre's acting like a admin.
  	 						  
  	 				password --> The password indicate security credential that is used to login to the DB server.
 */

package Establish_The_Connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Establish_Connection {
	
	
	public static void main(String[] args) {
	
		//step1 :  how to establish the connection with 3 String arguments
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded");
			/*
			String url1 = "jdbc:postgresql://localhost:5432/Company";
			String user = "postgres";
			String password = "root";
			
			Connection con1 = DriverManager.getConnection(url1, user, password);
			*/
			
		// step2 : establish the connection using 1 String argument
			/*
			String url2 = "jdbc:postgresql://localhost:5432/Company?user=postgres&password=root";
			Connection con2 = DriverManager.getConnection(url2);
			*/
			
		// step3 : how to establish the connection with url & properties obj
			   /*   
				1. Firstly we have to create a file with extension with the properties,
					inside the properties file we have to provide the DB Configuration information --> url,user,password
				   * Properties file store the data in the re1:value format.After we called fileInputStream to read the data.
			    2. fileInputStream basically attaches a stream to the properties file and using this stream the data can be read form the properties file.
			       While reading the data it will converted the character data to byte code by the stream and again it will convert back to character.
			    3. creating properties object, it will store the data key value format.
			       To fetch the data from properties file into the property object we need to make use of load() method which is present in property.
			       This load() method is non-static method it takes fileInputStream as a parameter.
			    4. To fetch the url which is present in properties object , to do that we need to make use of getProperty() method . It is non-static method , it take input parameter in String format.
			    5. getConnetion()  method takes the input parameter as URL, properties object.
			*/
			FileInputStream fis = new FileInputStream("config.properties");
			
			Properties property = new Properties();
			property.load(fis);
			
			String url = property.getProperty("url");
			
			Connection con3 = DriverManager.getConnection(url, property);
			
			System.out.println("Connetion Establish Sucessfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
