package backend;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class InsertQueries {

	private InsertQueries() {
		
	}
	
	public static void registerTraveler(JDBC app) {
		String call = "{call insert_traveler(?, ?, ?, ?)}";

		Connection myConn = app.connect();
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

	public static void getTravelers(JDBC app) {
		String call = "{call insert_traveler(?, ?, ?, ?)}";

		Connection myConn = app.connect();
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

	public static void getDrivers(JDBC app) {
		Connection myConn = app.connect();
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
