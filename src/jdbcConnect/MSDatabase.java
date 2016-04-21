package jdbcConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class MSDatabase {
	
	    Connection connection = null;
	   protected Connection setDbConnection() throws ClassNotFoundException {
		    
			try {
				
				 String dbUrl = "jdbc:mysql://192.168.8.118:3306/selenium";        
				
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
	   
	   public int getRowsCount(Connection connection, String tableName) throws SQLException {
			// select the number of rows in the table
			Statement stmt = null;
			ResultSet rs = null;
			int rowCount = -1;
			try {
				stmt = connection.createStatement();
				rs = stmt.executeQuery("SELECT COUNT(*) FROM " + tableName);
				// get the number of rows from the result set
				rs.next();
				rowCount = rs.getInt(1);
			} finally {
				rs.close();
				stmt.close();
			}
			return rowCount;
		}
	   
	   public int getColumnsCount(Connection connection, String tableName) throws SQLException {
			// select the number of rows in the table
		   Statement stmt = null;
			ResultSet rs = null;
			
				stmt = connection.createStatement();
				rs = stmt.executeQuery("SELECT * FROM " + tableName);
				ResultSetMetaData rsMetaData = rs.getMetaData();
			    int columnCount = rsMetaData.getColumnCount();
			    return columnCount;
	   }
}