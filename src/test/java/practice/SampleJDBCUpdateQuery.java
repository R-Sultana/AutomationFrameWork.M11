package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCUpdateQuery {

	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qspi11","root","123456");
		
		Statement state = con.createStatement();
		
		 int result = state.executeUpdate("insert into stu_info values(105,'Mistu','Kolkata');");
		if(result==1) {
			System.out.println("Data Added");
		}
		ResultSet result1 = state.executeQuery("select * from stu_info");
		while(result1.next()) {
			System.out.println(result1.getString(1)+"==> "+result1.getString(2)+"==> "+result1.getString(3));
		}
		
		con.close();
	}

}
