package main.java.testName.userService;

import static main.java.testName.Group.Applicant;
import static main.java.testName.Group.Company;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import main.java.testName.Group;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserLoginService implements UserDetailsService{

	private static volatile ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
	private static volatile ConcurrentHashMap<User, UserDetails> usersDetails = new ConcurrentHashMap<>();
	
	static {
		finalizeUser(new User(Applicant,"app@app.app","apppass"), new UserDetails("app",555,"test",444));
		finalizeUser(new User(Company,"co@co.co","copass"), new UserDetails("co",565,"test",432));
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
	
	public User getLogedInUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth==null){
			return null;
		}
	    String name = auth.getName();
	    return users.get(name);
	}
	
	public boolean nameFree(String username){
		return !users.containsKey(username);
	}
	
	public static void finalizeUser(User user, UserDetails userDs){
		users.put(user.getUsername(),user);
		usersDetails.put(user,userDs);
	}
	
	public List<User> applicantlist(){
		List<User> res= new LinkedList<User>();
		for(User u:users.values()){
			if(u.getUserGroup()==Group.Applicant){
				res.add(u);
			}
		}
		return res;
	}
	
	public UserDetails getUserDetails(User u){
		return usersDetails.get(u);
	}
}
