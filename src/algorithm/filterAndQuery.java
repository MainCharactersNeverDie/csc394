package algorithm;

import java.util.HashMap;

public class filterAndQuery {
	HashMap<String, HashMap<String, Integer>> Result;
	HashMap<String, String> filters;
	
	public filterAndQuery(HashMap<String, Integer> input){
		
		querier(input);
	}
	
	public void querier(HashMap<String, Integer> input) {
		//         COMING SOON!
	}
	
	public HashMap<String, HashMap<String, Integer>> get() {
		
		return Result;
	}
}
