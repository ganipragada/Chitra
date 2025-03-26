package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		Driver driverRef = new Driver();
		// stop no 1= register the database.
		DriverManager.registerDriver(driverRef);
		// stop no 2 = get the connecton.
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gani", "root", "Gani123@");
		// stop no 3 = issue create statement
		Statement state = conn.createStatement();
		// step no 4 = execute a qurey
		ResultSet result = state.executeQuery("select * from Ganiinfo;");
		while (result.next()) {
			System.out.println(result.getString(1) + " " + result.getInt(2) + " " + result.getString(3));
		}
		// stop no 5 = close the connection.
		conn.close();
	}
}
