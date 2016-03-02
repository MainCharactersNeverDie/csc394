package main.java.testName.userService;

public class UserDetails {
	private String name;
	private int ssn;
	private String address;
	private int number;
	
	public UserDetails(String nameIn, int ssnIn, String addressIn, int numberIn){
		name=nameIn;
		ssn=ssnIn;
		address=addressIn;
		number=numberIn;
	}

	public String getName() {
		return name;
	}

	public int getSsn() {
		return ssn;
	}

	public String getAddress() {
		return address;
	}

	public int getNumber() {
		return number;
	}
	
	
}
