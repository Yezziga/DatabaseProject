package backend;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQueries {
	
	public InsertQueries() {
	}
	
	public void registerTraveler() {
		String call = "{call insert_traveler(?, ?, ?, ?)}";

		Connection myConn = JDBC.getConnection();
		CallableStatement stmt = null;
		try {
			stmt = myConn.prepareCall(call);
			stmt.setString(1, "Java");
			stmt.setString(2, "Java2");
			stmt.setString(3, "Java3");
			stmt.setString(4, "Java4");

			stmt.execute();

			stmt.close();
			myConn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
