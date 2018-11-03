package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
	 private final String url = "jdbc:postgresql://pgserver.mah.se/ah7658project";
	    private final String user = "ah7658";
	    private final String password = "aer0jpco";
	 
	    /**
	     * Connect to the PostgreSQL database
	     *
	     * @return a Connection object
	     */
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
	 
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        App app = new App();
	        app.connect();
	    }
}
