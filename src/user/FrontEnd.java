package user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FrontEnd {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ArrayList<User> userList = new ArrayList<User>();
		
		userList.add(new User("ryan", "12345", new ArrayList<String>(Arrays.asList("ryan@gmail.com", "ryan@cox.net"))));
		userList.add(new GoldUser("johndoe", "abcd", new ArrayList<String>(Arrays.asList("jd123@gmail.com", "johndoe@hotmail.com"))));
		
		IUserAccessor userAccessor = new MockedUserAccessor(userList);
		UserEngine userEngine = new UserEngine(userAccessor);
		User u = null;
		
		System.out.println("Welcome to the application! Please login to continue.");
		
		boolean invalidLogin = true;
		
		while(invalidLogin) {
			
			System.out.println("Username: ");
			String username = s.next();
			System.out.println("Password: ");
			String password = s.next();
			
			u = userEngine.getUser(username, password);
			//Check that the login was valid
			if(u != null) {
				invalidLogin = false;
			}
			//Print invalid login, allow person to try again
			else {
				System.out.println("Invalid login information. Please retype username and password.");
			}
		}
		
		s.close();
		String userType = "User";
		if(u instanceof GoldUser) {
			userType = "Gold User";
		}

		System.out.printf("You have successfully logged in, %s %s. ", userType, u.getUsername());
		System.out.printf("You have a %.2f%% discount on items.", u.getDiscountRate()*100);
	}

}
