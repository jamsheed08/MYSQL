package jdbcConnect;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;

public class SQLConnector {
	
	@Test
	public void getData() throws SQLException, ClassNotFoundException {       

		//Create Connection to DB       
		MSDatabase db = new MSDatabase();
		Connection con = 	db.setDbConnection();

		System.out.println("Connected");

		//Create Statement Object       
		Statement stmt = con.createStatement();        

		
		System.out.println("Rows Count : "+db.getRowsCount(con, "emp"));
		System.out.println("Column Count : "+db.getColumnsCount(con, "emp"));
		
		//Query to Execute      
		String query = "select * from emp;";  

		// Execute the SQL Query. Store results in ResultSet        
		ResultSet rs= stmt.executeQuery(query);                         

		// While Loop to iterate through all data and print results     
		while (rs.next()){
			String eno = rs.getString(1);                                        
			String ename = rs.getString(2);                                                
			System. out.println(eno+"  "+ename);     
		}       
		// closing DB Connection       
		con.close();            
	}
	@BeforeMethod
	public void beforeMethod() {
		// System.out.println("Before Method");
	}

	@AfterTest
	public void afterTest() {
		// System.out.println("After Test");
	}

}
