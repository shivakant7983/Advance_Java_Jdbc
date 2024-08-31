package Executing_Statement_Object.Transaction_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/*
  Transaction Management : 
  						  Transaction management is the process of explicitly controlling the execution of the query by the programmer.
  						  By default in java the auto-commit is set to true.
  						  That means when we execute the query the statement will take the query from java application to the DB & it will execute 
  						  the query after executing , first the query will be present in cache memory of the database, and since the set
  						  auto-commit is by default true, it is getting permanently save in the database table.
  						  So to perform transaction management we have to make setautocommit setting as false, we can do that using setAutoCommit()
  						  method which is present in connection.
  						  
  	* setAutoCommit() --> The setAutoCommit is non-static method , which is present in connection. It is a parameterized method.
  						  It takes boolean as an input parameter, true indicates that commit operation will be done implicitly.
  						  False indicates that the transaction management explicitly done by the programmer.`
  				syntax : con.setAutoCommit(false);
  						  After setAutoCOmmit() false if we want to execute any query than explicitly we have to use commit() method.
  						  Without the commit() method the query will be executed but it will be present in the cache memory.
  						  So it will not making any permanently changes in the database table.
  						  By performing the commit() the execute query which will in cache memory will be permanently saved in database table.
 */
public class Commit {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded");
			String url = "jdbc:postgresql://localhost:5432/Company";
    		String user = "postgres";
    		String password = "root";
    		
    		Connection con = DriverManager.getConnection(url, user, password);
    		System.out.println("Connection extablished");
    		
    		con.setAutoCommit(false);
    		
    		 String query = "insert into employees values(94,'Avdhesh' , 300 , 9876)";
 	        String query2 = "insert into employees values(92,'Wipro' , 400 , 0876)";
 	        String query3 = "insert into employees values(93,'Nishant' , 500 , 3876)";
 	        
 	        Statement stm = con.createStatement();
 	        
 	        int r1 = stm.executeUpdate(query);
 	        int r2 = stm.executeUpdate(query2);
 	        int r3 = stm.executeUpdate(query3);
 	        
 	        System.out.println(r1);
 	        System.out.println(r2);
 	        System.out.println(r3);
 	      
 	        con.commit();
 	      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
