package backend;

import java.util.ArrayList;

public class testRunner {

	public static void main(String[] args) {
		Queries q = new Queries();
		
		ArrayList<String> s =  q.getQueries.getDriver("197801082222");
		System.out.print(s);

	}
}
