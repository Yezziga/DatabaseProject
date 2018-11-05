package backend;

import java.sql.*;

public class App {
	private final String url = "jdbc:postgresql://pgserver.mah.se/ah7658project"; // change which database to connect to
	private final String user = "ah7658";
	private final String password = "aer0jpco";

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

	public static void main(String[] args) {
		App app = new App();
		
		//getDrivers(app);
		registerTraveler(app);
	}
	
	public static void registerTraveler(App app) {
		String call = "{call insert_traveler(?, ?, ?, ?)}";
		
		Connection myConn = app.connect();
		CallableStatement stmt = null;
		try {
			stmt = myConn.prepareCall(call);
			stmt.setString(1,"Java");
			stmt.setString(2,"Java2");
			stmt.setString(3,"Java3");
			stmt.setString(4,"Java4");
			
			stmt.execute();
			
			stmt.close();
			myConn.close();
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
	
		public static void getTravelers(App app) {
			String call = "{call insert_traveler(?, ?, ?, ?)}";
			
			Connection myConn = app.connect();
			CallableStatement stmt = null;
			try {
				stmt = myConn.prepareCall(call);
				stmt.setString(1,"Java");
				stmt.setString(2,"Java2");
				stmt.setString(3,"Java3");
				stmt.setString(4,"Java4");
				
				stmt.execute();
				
				stmt.close();
				myConn.close();
				
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
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
	
	
	private static void getDrivers(App app) {
		Connection myConn = app.connect();
		Statement stmt = null;
		try {
			stmt = myConn.createStatement();
			
			String sql;
			sql = "SELECT * FROM DRIVER";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("person_nr"));
//				System.out.print(rs.getInt(""));
			}
			rs.close();
			stmt.close();
			myConn.close();
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
