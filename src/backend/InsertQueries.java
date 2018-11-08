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

	public int registerTraveler(String name, String email, String address, String phone_nr) {

		int traveler_id = -1;
		String call = "{call insert_traveler(?, ?, ?, ?)}";

		Connection myConn = JDBC.getConnection();
		CallableStatement stmt = null;
		try {
			stmt = myConn.prepareCall(call);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, address);
			stmt.setString(4, phone_nr);

			ResultSet rs = stmt.executeQuery();
			rs.next();

			traveler_id = rs.getInt(1);
			System.out.println(traveler_id);

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
		return traveler_id;
	}

	public void registerDriver(String pnr, String name, String address, String phone_nr) {
		String call = "{call insert_driver(?, ?, ?, ?)}";

		Connection myConn = JDBC.getConnection();
		CallableStatement stmt = null;
		try {
			stmt = myConn.prepareCall(call);
			stmt.setString(1, pnr);
			stmt.setString(2, name);
			stmt.setString(3, address);
			stmt.setString(4, phone_nr);

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

	public void addDriverToTrip(String driverId, int tripId) {

		Connection myConn = JDBC.getConnection();
		Statement stmt = null;

		try {
			stmt = myConn.createStatement();

			String sql;
			sql = "UPDATE trip SET driver_person_nr = '" + driverId + "' WHERE trip_id = '" + tripId + "';";
//			sql = "UPDATE trip SET driver_person_nr = '2019' WHERE trip_id = '7';";

			stmt.execute(sql);
			
			
			System.out.println(sql);
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
