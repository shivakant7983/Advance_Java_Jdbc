package Executing_Statement_Object.Statement_Batch_Execution;

/*
 Batch Execution : 
 			Batch processing groups multiple queries into one unit and passes it in a single network trip to a database.
 			If we do not use use batch execution then executing each query the statement object has to make two rounds trips , in a real-time 
 			application there are going to be multiple user accessing the application in that case number of round trips will be very high because
 			of that application performance will be affected
 			
 			 
   *  How to work batch execution :- Instead of execution one query at a single time in batch execution multiple queries are added in the memory space
   									 called as add.
   									 Then the Statement will move to the entire batch which is consisting of multiple sql query in the DB.
   									 Then after reaching the DB each query which is present in the batch will be executed in FIFO order.
   									 So for the multiple query round trip prepared statement we do not add the multiple query inside the batch.
   									 
   									 Can add multiple Runtime value and then move the entire batch which is consisting of multiple Runtime value to the DB.
   									 Then the Runtime value will be set to the pre-compiled Query, And a query can be executed multiple times with different value.
   									 
   					* addBatch() --> In Statement to add multiple query in the Batch.
   					
   					
   					* executeBatch() --> executeBatch() method is non-static method , present in statement .
   					 					 Internally this method take the entire batch consisting of multiple sql queries to the DB & execute the queries in 
   					 					 the FIFO order. After executing the query it return integer type of array .
   					 					 The value of array represents how many records has been affected b y each query in the DB.
 			
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StatementBatch {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded");
			String url = "jdbc:postgresql://localhost:5432/Company";
    		String user = "postgres";
    		String password = "root";
    		
    		Connection con = DriverManager.getConnection(url, user, password);
    		System.out.println("Connection extablished");
    		
    		// creating Statement Object
    		Statement stm = con.createStatement();
    		
    		String insert1 = "insert into employees values (5,'Pawan',36879.00, 345678943)";
    		String insert2 = "insert into employees values (6,'Ishu',36879.00, 34567894)";
    		String insert3 = "insert into employees values (7,'Sagar',36879.00, 345678943)";
    		String delete = "delete from employees where id = 12";
    		
    		stm.addBatch(insert1);
    		stm.addBatch(insert2);
    		stm.addBatch(insert3);
    		stm.addBatch(delete);
    		
    		int[] res = stm.executeBatch();
    		for(int x:res) {
    			System.out.println(x);
    		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
