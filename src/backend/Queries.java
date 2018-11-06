package backend;
import java.sql.*;

public class Queries {
	
	public Queries() {
		this.insertQueries  = new InsertQueries();
		this.updateQueries  = new UpdateQueries();
		this.getQueries  = new GetQueries();
	}
	
	public InsertQueries insertQueries = null;
	public UpdateQueries updateQueries = null;
	public GetQueries getQueries = null;
}
