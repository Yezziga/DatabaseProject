package backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetQueries {

	public GetQueries() {
	}
	public Object[][] getAllTrips() {

		Connection myConn = JDBC.getConnection();
		Statement stmt = null;

		Object[][] resultArray = null;

		try {

			stmt = myConn.createStatement();

			String sql;
			sql = "SELECT count(*) AS totalRows from trip;";

			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			resultArray = new Object[rs.getInt("totalRows")][10];

			sql = "SELECT* FROM trip;";

			System.out.println(sql);

			rs = stmt.executeQuery(sql);
			int columnIndex = 0;
			while (rs.next()) {

				String[] rr = { rs.getString("route"), rs.getString("departure"), rs.getString("arrival"),
						rs.getString("price"), rs.getString("seats_left"), rs.getString("driver_person_nr"),
						rs.getString("trip_id") };

				resultArray[columnIndex] = rr;
				columnIndex++;
			}

			rs.close();
			stmt.close();
			myConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				myConn.close();
				System.out.println("con close");

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
				System.out.println("close");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultArray;
	}

	public Object[][] getTrips(String startPoint, String destination) {

		Connection myConn = JDBC.getConnection();
		Statement stmt = null;

		Object[][] resultArray = null;

		try {

			stmt = myConn.createStatement();

			String sql;
			sql = "SELECT count(*) AS totalRows from trip where route =(select route_id from route where starting_point = (SELECT city from city WHERE city_name =	 '"
					+ startPoint + "') AND destination = (SELECT city from city WHERE city_name = '" + destination
					+ "'));";

			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			resultArray = new Object[rs.getInt("totalRows")][10];

			sql = "SELECT* from trip where route =(select route_id from route where starting_point = (SELECT city from city WHERE city_name =	 '"
					+ startPoint + "') AND destination = (SELECT city from city WHERE city_name = '" + destination
					+ "'));";

			System.out.println(sql);

			rs = stmt.executeQuery(sql);
			int columnIndex = 0;
			while (rs.next()) {

				String[] rr = { rs.getString("route"), rs.getString("departure"), rs.getString("arrival"),
						rs.getString("price"), rs.getString("seats_left"), rs.getString("driver_person_nr"),
						rs.getString("trip_id") };

				resultArray[columnIndex] = rr;
				columnIndex++;
			}

			rs.close();
			stmt.close();
			myConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultArray;
	}

	public Object[][] getDrivers() {
		Connection myConn = JDBC.getConnection();
		Statement stmt = null;

		Object[][] resultArray = null;

		try {
			stmt = myConn.createStatement();

			String sql;
			sql = String.format("SELECT count(*) AS totalRows FROM DRIVER;").toString();

			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			resultArray = new Object[rs.getInt("totalRows")][10];

			sql = String.format("SELECT * FROM DRIVER").toString();
			System.out.println(sql);

			rs = stmt.executeQuery(sql);

			int columnIndex = 0;
			while (rs.next()) {

				String[] rr = { rs.getString("person_nr"), rs.getString("name"), rs.getString("address"),
						rs.getString("phone_nr") };
				resultArray[columnIndex] = rr;
				columnIndex++;
			}

			rs.close();
			stmt.close();
			myConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultArray;
	}

	public Object[][] getDriver(String pnr) {
		Connection myConn = JDBC.getConnection();
		Statement stmt = null;

		Object[][] resultArray = null;
		try {
			stmt = myConn.createStatement();

			String sql;
			sql = String.format("SELECT * FROM DRIVER WHERE person_nr = '%s';", pnr).toString();
			System.out.println(sql);

			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			resultArray = new Object[1][10];

			int columnIndex = 0;
			while (rs.next()) {

				String[] rr = { rs.getString("person_nr") + " " + rs.getString("name") + " " + rs.getString("address")
						+ " " + rs.getString("phone_nr") };
				resultArray[columnIndex] = rr;
				columnIndex++;

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

		return resultArray;
	}

	public Object[][] getMyBooking(int traveler_Id) {
		Connection myConn = JDBC.getConnection();
		Statement stmt = null;

		Object[][] resultArray = null;

		try {
			stmt = myConn.createStatement();

			String sql;
			sql = "SELECT count(*) AS totalRows FROM get_bookings(" + traveler_Id + ");";

			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			resultArray = new Object[rs.getInt("totalRows")][10];

			sql = "SELECT * FROM get_bookings( " + traveler_Id + ")";
			System.out.println(sql);

			rs = stmt.executeQuery(sql);

			int columnIndex = 0;
			while (rs.next()) {

				String[] rr = { rs.getString("booking_id"), rs.getString("route"), rs.getString("departure"),
						rs.getString("arrival"), rs.getString("total_price"), rs.getString("reserved_seats") };

				resultArray[columnIndex] = rr;
				columnIndex++;
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

		return resultArray;
	}

}
