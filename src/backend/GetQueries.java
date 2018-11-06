package backend;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GetQueries {
	
	public GetQueries() {
	}
	
	public ArrayList<String> getDriver(String pnr) {
		Connection myConn = JDBC.getConnection();
		Statement stmt = null;
		
		ArrayList<String> resultArray = null;
		try {
			stmt = myConn.createStatement();
			
			String sql; 
			sql = String.format("SELECT * FROM DRIVER WHERE person_nr = '%s';", pnr).toString();
			System.out.println(sql);
			
			ResultSet rs = stmt.executeQuery(sql);

			
			while (rs.next()) {
				
				resultArray = new ArrayList<String>();				
				resultArray.add(rs.getString("person_nr"));
				resultArray.add(rs.getString("name"));
				resultArray.add(rs.getString("address"));
				resultArray.add(rs.getString("phone_nr"));				
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
