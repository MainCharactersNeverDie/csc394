package main.java.testName.questions;

import java.util.concurrent.ConcurrentHashMap;

import main.java.testName.userService.User;


public class QuestionDAO {
	private static volatile ConcurrentHashMap<Long,Question> questions = new ConcurrentHashMap<>();
	private static volatile ConcurrentHashMap<User,Long> userIndex = new ConcurrentHashMap<>();
	private static volatile ConcurrentHashMap<UserQuestionPair,String> answers= new ConcurrentHashMap<>();
	
	private static volatile long numOfQs=0L;
	
	public void addQuestion(Question q){
		questions.put(numOfQs++, q);
	}
	public Question getUserQuesition(User u){
		if(!userIndex.containsKey(u)){
			userIndex.put(u,0L);
		}
		System.out.println(userIndex.get(u));
		return questions.get(userIndex.get(u));
	}
	
	public void answerQuestion(User u, Question q, String answer){
		System.out.println("gothere");
			userIndex.put(u,userIndex.get(u)+1);
			answers.put(new UserQuestionPair(u,q), answer);
	}
	
	public String getAnswer(User u,Question q){
		String res= answers.get(new UserQuestionPair(u,q));
		return (res!=null)?res:"";
	}
}
