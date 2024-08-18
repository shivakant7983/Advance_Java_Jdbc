/*
  Register Driver : 
  					* To resister the driver we need to make use of register method which is present in Driver Manager.
  					* Driver Manager is helper class present in java.sql package.
  					* RegisterDriver method is static method.
  					* The RegisterDriver method is internally Upcasting the Driver implementation class to doing 
  					  the driver interface which is present in JDBC.
  					
 */

package Load_Register_Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class Register_Driver {

	public static void main(String[] args) {
	
    Driver d = new Driver();
    
    try {
		DriverManager.registerDriver(d);
		System.out.println("Regsiter the Driver");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
