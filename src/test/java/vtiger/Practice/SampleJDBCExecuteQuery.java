package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	
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
		
		//Step 4: Execute Query //give table name
		ResultSet res = sta.executeQuery("select * from wcsm_info;");
		System.out.println(res);
		while(res.next())
		{
			System.out.println(res.getString(1)+"-"+res.getInt(2)+"-"+res.getString(3));
		}
		
		//Step 5: Close database
		con.close();
		System.out.println("Db closed");
	}

}
