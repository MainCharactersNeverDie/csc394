package main.java.testName;

import org.springframework.security.core.GrantedAuthority;

public enum Group implements GrantedAuthority{
	Applicant,
	Company,
	Admin;

	@Override
	public String getAuthority() {
		return "ROLE_USER";
	}
}
