package main.java.testName.alg;

import main.java.testName.jobs.Job;
import main.java.testName.userService.User;

public class JobUserPair {
	private Job j;
	private User u;
	
	public JobUserPair(Job jIn, User uIn){
		j=jIn;
		u=uIn;
	}

	public Job getJ() {
		return j;
	}

	public User getU() {
		return u;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((j == null) ? 0 : j.hashCode());
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
		JobUserPair other = (JobUserPair) obj;
		if (j == null) {
			if (other.j != null)
				return false;
		} else if (!j.equals(other.j))
			return false;
		if (u == null) {
			if (other.u != null)
				return false;
		} else if (!u.equals(other.u))
			return false;
		return true;
	}
	
	
}
