package Executing_Statement_Object.Prepared_Statement_DML;

/*
 PreparedStatement :- A PreparedStatement is pre-compiled SQL statement. It is a subinterface of Statement.
 					  Prepared Statement objects have some useful additional features than Statement objects.
 					  This accepts parameterized SQL quires and you cab pass 0 or more parameters to this query.
 					  Intitally this statement uses place holders " ? " insetead of parameters, later on you can pass argument to these dynamically using the setXX() methods of the preapreadStatement interface.
 					  where xx stands for Int,Float,Double,String..etc.
 					  We are passing parameter (?) for the values , its values will be set by calling the setter method of PreparedStatement.(prepareStatement()).
 					  
 				prepareStatement() method accepts a query(parameterized) and return the object of PreparedStatement.
 				You can create an objects of the PareparedStatement (interface) using the prepareStatement() method of the connection interface.
 					  
 		difference b/w Statement vs PreparedStatement --> Statement will be used for executing static SQL statement and can't accept input parameters.
 														  PreparedStatement will be used for executing SQL statement many times dynamically. It will accept input parameters.
 														  
 		Executing the PreparedStatement --> Once you have created the PrepreadStatement object you can execute it using one of the execute() methods of the PrepreadStatement interface namely , execute(),executeUpdate() and executeQuery().
 		
 			 execute() -> This method executes normal static sql statement in the current prepared statement and return a boolean values.
 			 executeQuery() -> This method executes the current prepared statement and returns a ResultSet object.
 			 executeUpdate() -> This method executes Sql DML statement such as insert , update or delete in the current Prepared Statement. It returns an integer value representing the number of rows affected.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {

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
			String query = "insert into employees values(?,?,?,?)";
			//creating PreparedStatement object
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, 1);
			ps.setString(2, "Shivakant");
			ps.setDouble(3, 25550.3);
			ps.setLong(4, 895653645l);
			
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
			System.out.println("Enter the ID ");
			int id = sc.nextInt();
			System.out.println("Enter the name");
			String name = sc.next();
			System.out.println("Enter the salary");
			Double salary = sc.nextDouble();
			System.out.println("Enter the phone number");
			Long number = sc.nextLong();
			sc.nextLine();
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, salary);
			ps.setLong(4, number);
			
			boolean rs2 = ps.execute();
			System.out.println("rs2 : " + rs2);
			
			
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
