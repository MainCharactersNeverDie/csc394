package main.java.testName.userService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import main.java.testName.Group;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private Group userGroup;
	private String password;
	private String username;
	
	User(Group userGroupIn, String usernameIn, String passwordIn){
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

}
