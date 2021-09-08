package user;

import java.util.List;

public class User {

	//We use the private modifier in order to limit the accessibility of these attributes to instances of Users
	
	private String username;
	private String hashedPassword;
	private List<String> emails;
	
	//Constructors are public so that other classes can call them in order to create User objects
	
	public User(String username, String hashedPassword, List<String> emails) {
		this.username = username;
		this.hashedPassword = hashedPassword;
		this.emails = emails;
	}
	
	//Methods can be private or public; private methods can only be used within the class, while public methods can be called outside of the class
	
	public String getUsername() {
		return this.username;
	}
	
	public String getHashedPassword() {
		return this.hashedPassword;
	}
	
	public List<String> getEmails(){
		return this.emails;
	}
	
	/*
	 * Regular users receive no discount on items
	 */
	public double getDiscountRate() {
		return 0;
	}
	
	public boolean equals(User u) {
		if(u.getUsername().equals(this.username) && u.getHashedPassword().equals(this.hashedPassword) && u.getEmails().equals(this.emails)) {
			return true;
		}
		return false;
	}
}
