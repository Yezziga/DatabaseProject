package backend;

import java.sql.*;

public final class JDBC {

	private JDBC() {
		conn = getConnection();
	}

	final static String url = "jdbc:postgresql://pgserver.mah.se/ah7658project"; // change which database to connect to
	final static String user = "ah7658";
	final static String password = "aer0jpco";
	private static Connection conn = null;

	public static Connection getConnection() {

		try {
			if (conn.isClosed() || conn == null) {

				conn = DriverManager.getConnection(url, user, password);
				System.out.println("Connected to the PostgreSQL server successfully.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}
}
