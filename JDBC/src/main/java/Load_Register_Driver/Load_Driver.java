/*
 JDBC -->
 	*	It stands for Java to DataBase Connectivity
 	*	It is an API.  API helps to establish the communication between the two application.
 	*	Using JDBC we cab only communicate with relational database.
 	*	JDBC is present in JDK.
 	*	The fully qualified name (java.sql).  This sql is nothing but JDBC API.
 	*	Inside JDBC there are interface and helper classes.
 	*	JDBC helps to communicate b/w java application and database using 5 steps : 
 		
 		1. Load/Register the Driver
 		2. Establishing the connection
 		3. Create Statement object 
 		4. Executing Statement Object
 		5. Terminating the connection
 * 
 */


package Load_Register_Driver;


/*
  Step 1 : 
  		  Driver Software --> Driver Software is a software which acts like a translator.
  		  					  It translates Java app. to database language and 
  		  					  also translates the database language to java app.  .
  		  					  
  		  Load the driver :  The Driver software is provide by specific database vendor.
  		  					 That means, if the database is provided by MySql , 
  		  					 it needs to use the use the MYSQL Driver Software 
  		  					 that will provided by MYSQL .
  		  					 
  		  					 In this , i am using POSTGRESQl
  		  		Class --> class is the name of the class which is present in java.lang package, we can use forName 
  		  				  method which is present in the class to load the driver.
  		  				  forName method is static method it take fully qualified name of a class as input parameter in
  		  				  String "  ".
  		  					 
 */

public class Load_Driver {

	public static void main(String[] args) throws ClassNotFoundException{
		
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver Loaded");
	}
}
