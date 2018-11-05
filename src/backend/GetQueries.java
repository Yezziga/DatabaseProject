package backend;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetQueries {
	
	public GetQueries() {
	}
	
	public static void getDrivers(JDBC app) {
		Connection myConn = app.getConnection();
		Statement stmt = null;
		try {
			stmt = myConn.createStatement();

			String sql;
			sql = "SELECT * FROM DRIVER";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getString("person_nr"));
				// System.out.print(rs.getInt(""));
			}
			rs.close();
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
