package Executing_Statement_Object.Transaction_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
  RollBack Operation :- The RollBack operation removes the executed query from the cache memory of DataBase.
  						To perform the roolback operation we need to make use of rollback() method.
  						
  				rollback() -> It is the non-static method present in the connection , it is overloaded method.
  							  rollbak();
  							  rollback(SavePiont sp);
  							  
  				rollbak()-->If we used the rollback method before the commit , it will remove all the executeed query from the databse cache memory.
  						    If we used the rollback method after the commit then it won't have any impact.
  						    
  			    rollback(SavePiont sp) --> If we used rollback(SavePiont sp) method it will not remove the all the executed query from the DB cache memory.
  			    						   It will remove permanently all the executed query after the savePiont in the DB cache memory.
  			    						   To do this operation we have to create the savePoint .
  			    		
 */
public class Rollback {

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
	        String query = "insert into employees values(44,'vdhesh' , 300 , 9876)";
	        String query2 = "update employees set salary = 50 where id=5";
	        String query3 = "delete from employees where id = 101";
	        
	        Statement stm = con.createStatement();
	       int r1 = stm.executeUpdate(query);
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
	    	   con.rollback();
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
}
