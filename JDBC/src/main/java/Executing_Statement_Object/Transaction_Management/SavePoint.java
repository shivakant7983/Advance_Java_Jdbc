package Executing_Statement_Object.Transaction_Management;

/*
  SavePoint : The SavePoint act likes a marker above this marker whatever query are executed will be save in the cache
  			  memory , And the query that are executed after the savePoint will be removed from the cache memory.
  			  To create a savePiont we need to take the help of SavePiont interface.
  			  AS it is a interface direct object creation is not possible , so we need to take help of
  			  setSavepoint() method which is present in connection.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePoint {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			
			String url = "jdbc:postgresql://localhost:5432/Company";
			String user = "postgres";
			String password = "root";
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
			
			
			con.setAutoCommit(false);
	        String query = "insert into employees values(14,'vdhesh' , 300 , 9876)";
	        String query2 = "update employees set salary = 50 where id=5";
	        String query3 = "delete from employees where id = 13";
	        
	        Statement stm = con.createStatement();
	        
	       int r1 = stm.executeUpdate(query);
	       Savepoint sp = con.setSavepoint();
	       
	       int r2 = stm.executeUpdate(query2);
	       int r3 = stm.executeUpdate(query3);
	       System.out.println(r1);
	       System.out.println(r2);
	       System.out.println(r3);
	       
	       if(r1>0 && r2>0 && r3>0) {
	    	   con.commit();
	    	   System.out.println("Query commited successfully");
	       }
	       else {
	    	   con.rollback(sp);
	    	   System.out.println("Queries are rolled back");
	       }
	       con.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  
		
	}

/*
Step 5 : Terminate the connection --
									It is mandatory & a programmers responsibility to close the connection because the connection is the costly resources.
									If one application is connected with the database , until & unless that application cannot connect to the database.
									con.close();
*/

	
}