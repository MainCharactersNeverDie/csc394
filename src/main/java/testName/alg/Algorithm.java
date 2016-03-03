package main.java.testName.alg;

import java.util.ArrayList;
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
	
	private List<QuestionAnswerPair> cultureQuestions=new ArrayList<>();;
	private List<QuestionAnswerPair> techQuestions=new ArrayList<>();;
	private List<QuestionAnswerPair> allQuestions=new ArrayList<>();;
	
	{
		cultureQuestions.add(new QuestionAnswerPair(new RadialQuestion("question1","test1","test2","test3"),"1"));
		cultureQuestions.add(new QuestionAnswerPair(new RadialQuestion("question2","test1","test2","test3"),"0"));
		cultureQuestions.add(new QuestionAnswerPair(new RadialQuestion("question3","test1","test2","test3"),"1"));
	}
	//Radial Question answers are strings containing the 0-based index of the right answer.
	{
		techQuestions.add(new QuestionAnswerPair(new RadialQuestion("tquestion1a","test1","test2","test3"),"0"));
		techQuestions.add(new QuestionAnswerPair(new RadialQuestion("tquestion2a","test1","test2","test3"),"1"));
		techQuestions.add(new QuestionAnswerPair(new RadialQuestion("tquestion","test1","test2","test3"),"2"));
	}	
	
	{
		allQuestions.addAll(cultureQuestions);
		allQuestions.addAll(techQuestions);
	}
	
	@Autowired
	private UserLoginService uls;
	
	@Autowired
	private QuestionDAO qdoa;
	
	private static volatile boolean done=false;
	@PostConstruct
	public synchronized void transferQuestions() {
		if (!done) {
			done = true;
			System.out.println(qdoa);
			for (QuestionAnswerPair q : allQuestions) {
				qdoa.addQuestion(q.getQuestion());
			}
		}
	}
	
	public List<Result> getMatches(List<Job> js){
		List<Result> result= new ArrayList<>();
		System.out.println(js);
		for (Job j : js) {
			for (User u : uls.applicantlist()) {
				result.add(new Result(u, j.getTitle(), Score(u,cultureQuestions), Score(u,techQuestions), Score(u, allQuestions),uls.getUserDetails(u).getName()));
			}
		}
		return result;
	}
	
	public double Score(User u, List<QuestionAnswerPair> qs){
		int answers= 0;
		int questions=0;
		
		for(QuestionAnswerPair q:qs){
			questions++;
			System.out.println(qdoa.getAnswer(u, q.getQuestion()));
			if(qdoa.getAnswer(u, q.getQuestion()).equals(q.getAnswer())){
				answers++;
			}
		}
		
		return (answers*100.0)/questions;
	}
	
	
}
