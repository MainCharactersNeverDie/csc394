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
	private List<QuestionAnswerPair> allQuestions=new ArrayList<>();;
	
	{
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"What is the ideal size of the company that you would want to work for?","A few dedicated people in a garage","A giant corporation with thousands of staff worldwide","An office full of people in one location"),"1"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"When you go to work, what would you prefer to wear?","Super Casual","Business Casual","Business Formal","No preference"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"Whenever you are given a task, there are always resources available to you in the form of your co-workers. How would you utilize those resources?","Work on the task alone","Form a task group to tackle the problem","Use your co-workers on a need basis"),"2"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"What are your ideal work hours?","Nine to five, like the song","Flexibility in when I work is important, as long as I get my 8 hours in","I work all the time, nights, weekends, doesn't matter"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"Is the organization of a company important to you, and if so, how much?","I have no interest in heirarchy","Organization is the key to success","I'm just a cog in the wheel"),"2"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"Are you a people person?","Yes","No","Stop asking me questions!"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"Would you be comfortable reaching out to a client to help them solve their problems, even if your position doesn't necessarily require you to do so?","Yes, I have no problem calling a client","I would prefer to give the fix instructions to Customer Support so they can make contact, but I would if it was necessary","I would refuse to make that call, it wasn't in my original deal"),"2"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"How would you fare in an office cubicle farm?","I would wither and die","I don't have a preference","I like cubicles, it’s a place to keep my stapler"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"When do you feel the most productive?","First thing in the morning, when I have direction","Afternoons after all the meetings are done","I find I'm most productive at night, from home."),"2"));

	}
	//Radial Question answers are strings containing the 0-based index of the right answer.
	{
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"What programming language are you most comfortable with?","Java","Python","XCode"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"How many mobile apps have you published for either iOS or Android?","0 - 10","10-100","100+"),"2"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"What is the most efficient search algorithm to use when your data is unsorted?","Quick Sort","Insertion Sort","Bubble Sort"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"Could you code a website that matches potential employees to companies and their job postings?","Yes","No","Deja Vu"),"2"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"From which school did you get your Computer Science degree?","DePaul","DeVry","Other"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"How many licks does it take to get to the Tootsie Roll center of a Tootsie Pop?","3","Between 252 and 364","What does this have to do with anything?"),"1"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"What is your preferred operating system?","Mac","Linux","Windows"),"1"));
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
				qdoa.addQuestion(q);
			}
		}
	}
	
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
	
	public void addQuestion(QuestionAnswerPair qap){
		allQuestions.add(qap);
		qdoa.addQuestion(qap);
	}
	
}
