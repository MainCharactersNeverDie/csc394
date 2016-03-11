package main.java.testName.questions;

import java.util.concurrent.ConcurrentHashMap;

import main.java.testName.jobs.QuestionAnswerPair;
import main.java.testName.userService.User;


public class QuestionDAO {
	private static volatile ConcurrentHashMap<Long,QuestionAnswerPair> questions = new ConcurrentHashMap<>();
	private static volatile ConcurrentHashMap<User,Long> userIndex = new ConcurrentHashMap<>();
	private static volatile ConcurrentHashMap<UserQuestionPair,String> answers= new ConcurrentHashMap<>();
	
	private static volatile long numOfQs=0L;
	
	public void addQuestion(QuestionAnswerPair q){
		questions.put(numOfQs++, q);
	}
	public QuestionAnswerPair getUserQuesition(User u){
		if(!userIndex.containsKey(u)){
			userIndex.put(u,0L);
		}
		
		return questions.get(userIndex.get(u));
	}
	
	public void answerQuestion(User u, QuestionAnswerPair q, String answer){
		userIndex.put(u,userIndex.get(u)+1);
		answers.put(new UserQuestionPair(u,q.getQuestion()), answer);
		
		if(q.getQuestion().isTechQuestion()){
			u.answeredTechQuestion(answer.equals(q.getAnswer()));
		}else{
			u.answeredCulQuestion(answer.equals(q.getAnswer()));
		}
	}
	
	public String getAnswer(User u,Question q){
		String res= answers.get(new UserQuestionPair(u,q));
		return (res!=null)?res:"";
	}
}
