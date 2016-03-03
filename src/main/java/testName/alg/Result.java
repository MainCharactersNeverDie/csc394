package main.java.testName.alg;

import main.java.testName.userService.User;

public class Result {
	private User user;
	private String jobtitle;
	private double techScore;
	private double cultureScore;
	private double overalScore;
	private String name;
	
	public Result(User userIn, String jobtitleIn, double techScoreIn, double cultureScoreIn, double overalScoreIn, String nameIn){
		user=userIn;
		jobtitle=jobtitleIn;
		techScore=techScoreIn;
		cultureScore=cultureScoreIn;
		overalScore=overalScoreIn;
		name=nameIn;
	}
	
	public User getUser(){
		return user;
	}
	
	public String getJobTitle(){
		return jobtitle;
	}
	
	public String getTechScore(){
		return clip(techScore+"");
	}
	
	public String getCultureScore(){
		return clip(cultureScore+"");
	}
	
	public String getOveralScore(){
		return clip(overalScore+"");
	}
	public String clip(String s){
		return s.substring(0,Math.min(s.length(), 5));
	}
	public String getName(){
		return name;
	}
}
