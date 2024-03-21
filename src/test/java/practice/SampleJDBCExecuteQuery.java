package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver();
		
		//step1: Register driver/database
		DriverManager.registerDriver(driverRef);
		
		//step2: Create connection for DB
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qspi11","root","123456");
		
		//step3: Issue create statement
		Statement state = con.createStatement();
		
		//step4: execute query
		ResultSet result = state.executeQuery("select * from stu_info");
		while(result.next()) {
			System.out.println(result.getString(1)+" ==>"+result.getString(2)+"==>"+result.getString(3));
		}
		
		//ste5 : close DB
		con.close();
	}
}
