package main.java.testName.alg;

import main.java.testName.userService.User;

public class Result {
	private User user;
	private String jobtitle;
	private double techScore;
	private double cultureScore;
	private double overalScore;
	
	public Result(User userIn, String jobtitleIn, double techScoreIn, double cultureScoreIn, double overalScoreIn){
		user=userIn;
		jobtitle=jobtitleIn;
		techScore=techScoreIn;
		cultureScore=cultureScoreIn;
		overalScore=overalScoreIn;
	}
	
	public User getUser(){
		return user;
	}
	
	public String getJobTitle(){
		return jobtitle;
	}
	
	public double getTechScore(){
		return techScore;
	}
	
	public double getCultureScore(){
		return cultureScore;
	}
	
	public double getOveralScore(){
		return overalScore;
	}
}
