package main.java.testName.alg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import main.java.testName.jobs.Job;
import main.java.testName.jobs.QuestionAnswerPair;
import main.java.testName.questions.QuestionDAO;
import main.java.testName.questions.RadialQuestion;
import main.java.testName.userService.User;
import main.java.testName.userService.UserLoginService;

import org.springframework.beans.factory.annotation.Autowired;

public class Algorithm {

	
	private final static int MAX_RESULTS=10;
	
	@Autowired
	private UserLoginService uls;
	
	@Autowired
	private QuestionDAO qdoa;
	
	public List<Result> getMatches(List<Job> js){
		List<Result> result= new ArrayList<>();
		System.out.println(js);
		for (Job j : js) {
			for (User u : uls.applicantlist()) {
				result.add(new Result(u, j.getTitle(), u.getCultureScore(), u.getTechScore(), u.getTotalScore(),uls.getUserDetails(u).getName()));
			}
		}
		Collections.sort(result, new Comparator<Result>(){

			@Override
			public int compare(Result r1, Result r2) {
				return r2.getOveralScore().compareTo(r1.getOveralScore());
			}});
		return result.subList(0, Math.min(result.size(),MAX_RESULTS));
	}
	
}
