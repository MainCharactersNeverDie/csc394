package main.java.testName.userService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import main.java.testName.Group;
import main.java.testName.alg.JobUserPair;
import main.java.testName.alg.Score;
import main.java.testName.jobs.Job;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private List<String> badges = new LinkedList<String>();
	private static ConcurrentHashMap<JobUserPair,Score> scores= new  ConcurrentHashMap<>();
	
	private Group userGroup;
	private String password;
	private String username;
	
	public User(Group userGroupIn, String usernameIn, String passwordIn){
		userGroup=userGroupIn;
		username=usernameIn;
		password=passwordIn;
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list=new ArrayList<>();
		list.add(userGroup);
		return list;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	public Group getUserGroup(){
		return userGroup;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((userGroup == null) ? 0 : userGroup.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userGroup != other.userGroup)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public List<String> getBadges() {
		return badges;
	}
	
	public void giveBadge(String badge){
		badges.add(badge);
	}

	public int getCultureScore(Job j) {
		if(scores.get(new JobUserPair(j,this))==null){
			scores.put(new JobUserPair(j,this),new Score(0,0,0));
		}
		return scores.get(new JobUserPair(j,this)).getCul();
	}

	public int getTechScore(Job j) {
		if(scores.get(new JobUserPair(j,this))==null){
			scores.put(new JobUserPair(j,this),new Score(0,0,0));
		}
		return scores.get(new JobUserPair(j,this)).getTech();
	}

	public int getTotalScore(Job j) {
		if(scores.get(new JobUserPair(j,this))==null){
			scores.put(new JobUserPair(j,this),new Score(0,0,0));
		}
		return scores.get(new JobUserPair(j,this)).getTotal();
	}
	
	public void answeredTechQuestion(Job j, boolean right){
		if(scores.get(new JobUserPair(j,this))==null){
			scores.put(new JobUserPair(j,this),new Score(0,0,0));
		}
		System.out.println("answerd Tech Question for "+j.getTitle()+" was "+((right)?"correct":"wrong"));
		scores.put(new JobUserPair(j,this),new Score(scores.get(new JobUserPair(j,this)).getCul()+1,scores.get(new JobUserPair(j,this)).getTech(),scores.get(new JobUserPair(j,this)).getTotal()+1));
		
	}
	
	public void answeredCulQuestion(Job j, boolean right){
		if(scores.get(new JobUserPair(j,this))==null){
			scores.put(new JobUserPair(j,this),new Score(0,0,0));
		}
		System.out.println("answerd Cul Question for "+j.getTitle()+" was "+((right)?"correct":"wrong"));
		scores.put(new JobUserPair(j,this),new Score(scores.get(new JobUserPair(j,this)).getCul(),scores.get(new JobUserPair(j,this)).getTech()+1,scores.get(new JobUserPair(j,this)).getTotal()+1));
	}

	
}
