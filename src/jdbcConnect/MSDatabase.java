package jdbcConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSDatabase {
	
	    Connection connection = null;
	   protected Connection setDbConnection() throws ClassNotFoundException {
		    
			try {
				
				 String dbUrl = "jdbc:mysql://localhost:3306/selenium";        
				
				 //Database Username     
	            String username = "root";   
	             
	            //Database Password     
	            String password = "password";             

	            //Query to Execute      
	            String query = "select * from emp;";  
	             
	            //Load mysql jdbc driver        
	            Class.forName("com.mysql.jdbc.Driver");         
	        
	            //Create Connection to DB       
	            Connection connection = DriverManager.getConnection(dbUrl,username,password);
			//	connection = DriverManager.getConnection(getDbConnectionString(), getDbUserName(), getDbPassword());
			
				return connection;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}

	   	}
	   }
