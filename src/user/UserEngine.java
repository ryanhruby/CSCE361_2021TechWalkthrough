package user;

public class UserEngine {

	//An accessor that implements the IUserAccessor interface is a member attribute of the engine
	//When a class has other objects as attributes, this is known as composition
	private IUserAccessor userAccessor;
	
	//Note that the constructor accepts any object that implements IUserAccessor
	//This includes our MockedUserAccessor, but could also include another class that implements the interface, like UserAccessor
	public UserEngine(IUserAccessor userAccessor) {
		this.userAccessor = userAccessor;
	}
	
	public User getUser(String username, String hashedPassword) {
		return userAccessor.find(username, hashedPassword);
	}
	
	public User insertUser(User user) {
		return userAccessor.insert(user);
	}
	
}
