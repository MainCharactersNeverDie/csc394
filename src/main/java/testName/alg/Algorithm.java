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
	private final int MAX_RESULTS=20;
	private List<QuestionAnswerPair> cultureQuestions=new ArrayList<>();;
	private List<QuestionAnswerPair> techQuestions=new ArrayList<>();;
	private List<QuestionAnswerPair> allQuestions=new ArrayList<>();;
	
	{
		cultureQuestions.add(new QuestionAnswerPair(new RadialQuestion("What is the ideal size of the company that you would want to work for?","A few dedicated people in a garage","A giant corporation with thousands of staff worldwide","An office full of people in one location"),"1"));
		cultureQuestions.add(new QuestionAnswerPair(new RadialQuestion("When you go to work, what would you prefer to wear?","Super Casual","Business Casual","Business Formal","No preference"),"0"));
		cultureQuestions.add(new QuestionAnswerPair(new RadialQuestion("Whenever you are given a task, there are always resources available to you in the form of your co-workers. How would you utilize those resources?","Work on the task alone","Form a task group to tackle the problem","Use your co-workers on a need basis"),"2"));
		cultureQuestions.add(new QuestionAnswerPair(new RadialQuestion("What are your ideal work hours?","Nine to five, like the song","Flexibility in when I work is important, as long as I get my 8 hours in","I work all the time, nights, weekends, doesn't matter"),"0"));
		cultureQuestions.add(new QuestionAnswerPair(new RadialQuestion("Is the organization of a company important to you, and if so, how much?","I have no interest in heirarchy","Organization is the key to success","I'm just a cog in the wheel"),"2"));
		cultureQuestions.add(new QuestionAnswerPair(new RadialQuestion("Are you a people person?","Yes","No","Stop asking me questions!"),"0"));
		cultureQuestions.add(new QuestionAnswerPair(new RadialQuestion("Would you be comfortable reaching out to a client to help them solve their problems, even if your position doesn't necessarily require you to do so?","Yes, I have no problem calling a client","I would prefer to give the fix instructions to Customer Support so they can make contact, but I would if it was necessary","I would refuse to make that call, it wasn't in my original deal"),"2"));
		cultureQuestions.add(new QuestionAnswerPair(new RadialQuestion("How would you fare in an office cubicle farm?","I would wither and die","I don't have a preference","I like cubicles, it’s a place to keep my stapler"),"0"));
		cultureQuestions.add(new QuestionAnswerPair(new RadialQuestion("When do you feel the most productive?","First thing in the morning, when I have direction","Afternoons after all the meetings are done","I find I'm most productive at night, from home."),"2"));

	}
	//Radial Question answers are strings containing the 0-based index of the right answer.
	{
		techQuestions.add(new QuestionAnswerPair(new RadialQuestion("What programming language are you most comfortable with?","Java","Python","XCode"),"0"));
		techQuestions.add(new QuestionAnswerPair(new RadialQuestion("How many mobile apps have you published for either iOS or Android?","0 - 10","10-100","100+"),"2"));
		techQuestions.add(new QuestionAnswerPair(new RadialQuestion("What is the most efficient search algorithm to use when your data is unsorted?","Quick Sort","Insertion Sort","Bubble Sort"),"0"));
		techQuestions.add(new QuestionAnswerPair(new RadialQuestion("Could you code a website that matches potential employees to companies and their job postings?","Yes","No","Deja Vu"),"2"));
		techQuestions.add(new QuestionAnswerPair(new RadialQuestion("From which school did you get your Computer Science degree?","DePaul","DeVry","Other"),"0"));
		techQuestions.add(new QuestionAnswerPair(new RadialQuestion("How many licks does it take to get to the Tootsie Roll center of a Tootsie Pop?","3","Between 252 and 364","What does this have to do with anything?"),"1"));
		techQuestions.add(new QuestionAnswerPair(new RadialQuestion("What is your preferred operating system?","Mac","Linux","Windows"),"1"));
		techQuestions.add(new QuestionAnswerPair(new RadialQuestion("If you were asked to explain, in detail, how null pointers work in Java, could you?","Yes","No","Whats a null pointer?"),"2"));
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
		Collections.sort(result, new Comparator<Result>(){

			@Override
			public int compare(Result r1, Result r2) {
				return r2.getOveralScore().compareTo(r1.getOveralScore());
			}});
		return result.subList(0, Math.min(result.size(),MAX_RESULTS));
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
	
	public void addTechQuestion(QuestionAnswerPair qap){
		techQuestions.add(qap);
		allQuestions.add(qap);
		qdoa.addQuestion(qap.getQuestion());
	}
	
	public void addCulQuestion(QuestionAnswerPair qap){
		cultureQuestions.add(qap);
		allQuestions.add(qap);
		qdoa.addQuestion(qap.getQuestion());
	}
	
}
