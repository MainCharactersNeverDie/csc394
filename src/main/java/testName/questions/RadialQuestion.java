package main.java.testName.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.java.testName.jobs.Job;

public class RadialQuestion implements Question{
	private List<String> answers;
	private boolean tech;
	private Job j;
	
	public RadialQuestion(Job jIn, boolean techIn, String question, String... answersIn){
		answers=new ArrayList<>(Arrays.asList(answersIn));
		answers.add(0,question);
		tech=techIn;
		j=jIn;
	}
	
	@Override
	public String getQuestionStyle() {
		return "WEB-INF/views/question.jsp";
	}

	@Override
	public List<String> getAnswerList() {
		return answers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RadialQuestion other = (RadialQuestion) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		return true;
	}

	@Override
	public boolean isTechQuestion() {
		return tech;
	}
	
	@Override
	public Job getJob(){
		return j;
	}
	

}
