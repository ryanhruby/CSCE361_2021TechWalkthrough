package user;

import java.util.List;

//The extends keyword allows GoldUser to inherit from User
//Now, GoldUser can use all of User's methods

public class GoldUser extends User {
	
	public GoldUser(String username, String hashedPassword, List<String> emails) {
		//The super keyword allows GoldUser to use its parent's (User's) constructor
		super(username, hashedPassword, emails);
	}
	
	@Override
	/*
	 * All gold users receive a 15% discount on items
	 */
	public double getDiscountRate() {
		return 0.15;
	}
}
