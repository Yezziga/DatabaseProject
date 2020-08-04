package backend;

import java.sql.*;

public final class JDBC {

	private JDBC() {
		conn = getConnection();
	}

	final static String url = "jdbc:postgresql://pgserver.mah.se/"; // change which database to connect to
	final static String user = ""; //
	final static String password = ""; //
	private static Connection conn = null;

	public static Connection getConnection() {

		try {
			if (conn == null || conn.isClosed()) {

				conn = DriverManager.getConnection(url, user, password);
				System.out.println("Connected to the PostgreSQL server successfully.");
			}
			else {
				System.out.println("Already connected.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}
}
