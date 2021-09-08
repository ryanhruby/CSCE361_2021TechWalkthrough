package user;

import java.util.List;

//MockedUserAccessor implements the IUserAccessor interface, so it is now forced to implement the interface's methods

public class MockedUserAccessor implements IUserAccessor {
	
	//The userList will act as our "database" containing Users; in a real application, an accessor would access a database or other storage, not a list
	private List<User> userList;
	
	public MockedUserAccessor(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public User find(String username, String hashedPassword) {
		for(User u : userList) {
			if(u.getUsername().equals(username) && u.getHashedPassword().equals(hashedPassword)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public boolean exists(User user) {
		for(User u : userList) {
			if(u.equals(user)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User insert(User userToBeInserted) {
		userList.add(userToBeInserted);
		return userToBeInserted;
	}
	
}
