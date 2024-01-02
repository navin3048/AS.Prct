package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	
	@Test
	public void sample() throws SQLException
	{
		//Step 1: Register the driver to DB
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//Step 2: get the connection with database //give db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wcsm27", "root", "root");
	
		//Step 3: Issue create statement
		Statement sta = con.createStatement();
	
		//Step 4: Execute Update //give table name
		int res = sta.executeUpdate("insert into wcsm_info values('aaa',00,'aaa');");
		System.out.println(res);	
		if(res==1)
			System.out.println("Data added");
		else
			System.out.println("Data not added");
	
	}

}
