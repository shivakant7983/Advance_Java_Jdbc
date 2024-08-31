package Executing_Statement_Object.DQL_Execution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			
			String url = "jdbc:postgresql://localhost:5432/Company";
			String user = "postgres";
			String password = "root";
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established");
			
			Statement stm = con.createStatement();
		
			// writing a dynamic query using delegation(?)
			String query = "update employees set name = ? where id = ? ";
			//creating PreparedStatement object
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, "Vishesh");
			ps.setInt(2, 12);
			//using executeUpdate()
			
			int result1 = ps.executeUpdate();
			
			if(result1>0) {
				System.out.println("Query executed successfully");
			}
			else {
				System.out.println("Falid to execute");
			}
			
			System.out.println("================================");

			Scanner sc = new Scanner(System.in);
			System.out.println("enter the id");
    		int id = sc.nextInt();
    		sc.nextLine();
    		
    		System.out.println("enter the name");
    		String name = sc.nextLine();
    		
    		ps.setString(1, name);
            ps.setInt(2, id);
    		
    		boolean result2 = ps.execute();
    		System.out.println("result2 :"+result2);
			
			
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
