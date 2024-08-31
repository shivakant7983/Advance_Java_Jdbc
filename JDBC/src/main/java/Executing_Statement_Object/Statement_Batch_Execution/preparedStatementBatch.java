package Executing_Statement_Object.Statement_Batch_Execution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class preparedStatementBatch {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded");
			String url = "jdbc:postgresql://localhost:5432/Company";
    		String user = "postgres";
    		String password = "root";
    		
    		Connection con = DriverManager.getConnection(url, user, password);
    		System.out.println("Connection extablished");
    		
    		//writing a dynamic query using delegation(?)
    		String query = "insert into employees values(?,?,?,?)";
    		//creating PareparedStatement object
    		PreparedStatement ps = con.prepareStatement(query);
    		
    		ps.setInt(1, 9);
    		ps.setString(2, "Vishesh");
    		ps.setDouble(3, 580000);
    		ps.setLong(4, 9693074764l);
    		ps.addBatch();
    		
    		ps.setInt(1, 10);
    		ps.setString(2, "Mia");
    		ps.setDouble(3, 580000);
    		ps.setLong(4, 9012608439l);
    		ps.addBatch();
    		
    		int[] res = ps.executeBatch();
    		
    		for(int x:res) {
    			System.out.println(x);
    		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
