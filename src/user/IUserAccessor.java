package user;

public interface IUserAccessor {

	public User find(String username, String hashedPassword);
	public boolean exists(User user);
	public User insert(User userToBeInserted);
	
}
