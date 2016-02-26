package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class algControl {
	HashMap<String, HashMap<String, Integer>> result;
	HashMap<String, Integer> input;
	ArrayList<HashMap<String, HashMap<String, Integer>>> sortedList = new ArrayList<HashMap<String, HashMap<String, Integer>>>();
	Integer inputTotal = 0;
		
	
	
	public algControl(HashMap<String, Integer> input) {
		// Database Query Call
		filterAndQuery query = new filterAndQuery(input);
		result = query.get();
		
		// Max Job Score
		ArrayList<String> inTot = (ArrayList<String>) input.keySet();
		for(String key : inTot) {
			inputTotal += input.get(key);
		}
		
		valuer();
		
		sorter();
	}
	
	// Assigns Value to Applicant Attributes According to Job Attribute Values,
	// Adds a "TotalScore" Attribute,
	// Then Adds Applicants to an Unsorted ArrayList.
	public void valuer() {
		Iterator<Entry<String, HashMap<String, Integer>>> it = result.entrySet().iterator();
		
		// Runs Through the Applicants 
		while(it.hasNext()) {
			String id = it.next().getKey();
			HashMap<String, Integer> attrs = it.next().getValue();
			ArrayList<String> keys = (ArrayList<String>) attrs.keySet();
			
			HashMap<String, Integer> val = new HashMap<String, Integer>();
			HashMap<String, HashMap<String, Integer>> exp = new HashMap<String, HashMap<String, Integer>>();
			
			// Runs Through Applicants Attributes, and Evaluates Score
			for(int x = 0; x < keys.size()-1; x++) {
				String key = keys.get(x);
				Integer jobVal = input.get(key);
				
				if(attrs.get(key) <= jobVal) {
					val.put(key, attrs.get(key));
				}
				else {
					val.put(key, jobVal);
				}
			}
			exp.put(id, val);
			val = scoreBuilder(val);
			sortedList.add(exp);
			it.remove();
		}
	}
	
	// Creates Score Totals
	// and Adds the Total Score Attribute
	public HashMap<String, Integer> scoreBuilder(HashMap<String, Integer> applicant) {
		ArrayList<String> scores = (ArrayList<String>) applicant.keySet();
		Integer Total = 0;
		for(String key : scores) {
			Total += applicant.get(key);
		}
		
		applicant.put("TotalScore", Total);
		return applicant;
	}
	
	// Does a Bubble Sort of the ArrayList of Applicants
	public void sorter(){
		for (int i = (sortedList.size() - 1); i >= 0; i--)  {
			for (int j = 1; j <= i; j++)	{
				
				ArrayList<String> le = (ArrayList<String>) sortedList.get(j-1).keySet();
				String lef = le.get(0);
				HashMap<String,Integer> left = sortedList.get(j-1).get(lef); 
				
				ArrayList<String> ri = (ArrayList<String>) sortedList.get(j).keySet();
				String righ = ri.get(0);
				HashMap<String,Integer> right = sortedList.get(j).get(righ);
				
			    if (left.get("TotalScore") > right.get("TotalScore")) {
			    	
				        HashMap<String, HashMap<String, Integer>> temp = sortedList.get(j-1);
				        sortedList.set(j-1, sortedList.get(j));
				        sortedList.set(j, temp);
				    } 
				} 
			} 
		}
	
	// Get Method
	public ArrayList<HashMap<String, HashMap<String, Integer>>> get(){
		return sortedList;
	}
	
	
	
	public static void main(String[] args) {
	}
}
