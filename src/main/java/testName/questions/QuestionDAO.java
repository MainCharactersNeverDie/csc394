package main.java.testName.questions;

import java.util.concurrent.ConcurrentHashMap;

import main.java.testName.userService.User;


public class QuestionDAO {
	private static volatile ConcurrentHashMap<Long,Question> questions = new ConcurrentHashMap<>();
	private static volatile ConcurrentHashMap<User,Long> userIndex = new ConcurrentHashMap<>();
	private static volatile ConcurrentHashMap<UserQuestionPair,String> answers= new ConcurrentHashMap<>();
	
	static {
		questions.put(0L,new RadialQuestion("question","test1","test2","test3"));
	}
	
	private static volatile long numOfQs=1L;
	
	public void addQuestion(Question q){
		questions.put(numOfQs++, q);
	}
	public Question getUserQuesition(User u){
		if(!userIndex.contains(u)){
			userIndex.put(u,0L);
		}
		return questions.get(userIndex.get(u));
	}
	
	public void answerQuestion(User u, Question q, String answer){
			userIndex.put(u,userIndex.get(u)+1);
			answers.put(new UserQuestionPair(u,q), answer);
	}
}
