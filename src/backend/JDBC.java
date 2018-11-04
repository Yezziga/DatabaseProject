package backend;

import java.sql.*;

public class JDBC {
	private final String url = "jdbc:postgresql://pgserver.mah.se/ah7658project"; // change which database to connect to
	private final String user = "ah7658";
	private final String password = "aer0jpco";
	private Connection conn = null;
	
	public JDBC() {
		this.conn = connect();
		InsertQueries.getDrivers(app);
	}
	
	public Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}	
	
//	public static class GetQueries {
//		public void GetSetWow()
//		{
//			
//		}
//	}
//	
//	public static class InsertQueries {
//		
//	}
//
//	public static class UpdateQueries {
//		
//	}
}
