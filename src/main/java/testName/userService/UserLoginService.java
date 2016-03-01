package main.java.testName.userService;

import static main.java.testName.Group.Applicant;
import static main.java.testName.Group.Company;

import java.util.HashMap;

import main.java.testName.Group;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserLoginService implements UserDetailsService{

	private HashMap<String,User> users = new HashMap<>();
	{
		addUser(Applicant,"app@app.app","apppass");
		addUser(Company,"co@co.co","copass");
	}
	
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		if(!users.containsKey(username)){
			throw new UsernameNotFoundException(username);
		}
		User user=users.get(username);
		addUserToSecurityContext(user);
		return user;
	}
	
	private void addUserToSecurityContext(User user) {

	}

	public boolean addUser(Group userGroup, String username, String password){
		if(users.containsKey(username)){
			return false;
		}
		users.put(username,new User(userGroup, username, password));
		return true;
	}
	
	public User getLogedInUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth==null){
			return null;
		}
	    String name = auth.getName();
	    return users.get(name);
	}
}
