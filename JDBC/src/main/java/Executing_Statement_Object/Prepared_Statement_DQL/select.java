package Executing_Statement_Object.Prepared_Statement_DQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class select {

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
			String query = "select name,salary from employees where id = ? ";
			//creating PreparedStatement object
			PreparedStatement ps = con.prepareStatement(query);
		
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the id");
    		int id = sc.nextInt();
            ps.setInt(1, id);
    		
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
    			System.out.println(rs.getString(1)+" " + rs.getDouble(2));
    		}
			
			
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
