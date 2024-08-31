package Terminating_the_connection;
/*
	Step 5 : Terminate the connection --
		It is mandatory & a programmers responsibility to close the connection because the connection is the costly resources.
		If one application is connected with the database , until & unless that application cannot connect to the database.
		con.close();
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
public class Close_Connection {

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
		        String query = "insert into employees values(19,'dhesh' , 300 , 9876)";
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
		       
		       // Terminate the connection
		       con.close();
		       System.out.println("Connection Closed");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			  
			
		}	

}

