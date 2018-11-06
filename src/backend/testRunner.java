package backend;

import java.util.ArrayList;

public class testRunner {

	public static void main(String[] args) {
		Queries q = new Queries();
		
		ArrayList<String[]> s = q.getQueries.getDriver("199306231111");
		System.out.println(s.get(0)[0]);
	}
}
