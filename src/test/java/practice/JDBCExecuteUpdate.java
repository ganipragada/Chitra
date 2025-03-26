package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		Driver driverRef = new Driver();
		// step no 1 = register db
		DriverManager.registerDriver(driverRef);

		// step no 2 = get the connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gani", "root", "Gani123@");

		// step no 3 = get cteate statement
		Statement state = conn.createStatement();

		// step no 4 = execute a query
		String query = "insert into Ganiinfo values('raja', 25,'vijayawada')";
		int result = state.executeUpdate(query);
		if (result == 1) {
			System.out.println("data is added");
		}
	}
}
