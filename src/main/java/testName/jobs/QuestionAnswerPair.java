package main.java.testName.jobs;

import main.java.testName.questions.Question;

public class QuestionAnswerPair {
	private Question q;
	private String a;
	
	public QuestionAnswerPair(Question qIn, String aIn){
		q=qIn;
		a=aIn;
	}
	
	public Question getQuestion(){
		return q;
	}
	
	public String getAnswer(){
		return a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((q == null) ? 0 : q.hashCode());
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
		QuestionAnswerPair other = (QuestionAnswerPair) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (q == null) {
			if (other.q != null)
				return false;
		} else if (!q.equals(other.q))
			return false;
		return true;
	}
}
