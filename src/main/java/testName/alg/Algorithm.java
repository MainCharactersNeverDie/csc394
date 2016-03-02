package main.java.testName.alg;

import java.util.ArrayList;
import java.util.List;

import main.java.testName.Group;
import main.java.testName.userService.User;

public class Algorithm {
	public List<Result> getMatches(){
		List<Result> result= new ArrayList<>();
		result.add(new Result(new User(Group.Applicant, "Dude A", "password"),"Sr. Hamster Wrangler",90.0,65.0,77.5));
		result.add(new Result(new User(Group.Applicant, "Guy B", "password"),"Sr. Hamster Petter",80.0,79,79.5));
		return result;
	}
}
