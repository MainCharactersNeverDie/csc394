package main.java.testName.questions;

import main.java.testName.userService.User;

public class UserQuestionPair {
	private User u;
	private Question q;
	
	UserQuestionPair(User uIn, Question qIn){
		u=uIn;
		q=qIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((q == null) ? 0 : q.hashCode());
		result = prime * result + ((u == null) ? 0 : u.hashCode());
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
		UserQuestionPair other = (UserQuestionPair) obj;
		if (q == null) {
			if (other.q != null)
				return false;
		} else if (!q.equals(other.q))
			return false;
		if (u == null) {
			if (other.u != null)
				return false;
		} else if (!u.equals(other.u))
			return false;
		return true;
	}

	public User getU() {
		return u;
	}

	public Question getQ() {
		return q;
	}

	
}
