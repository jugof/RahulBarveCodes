package example.spring.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	//This class is meant for holding a list of users
	private static List<User> availableUsers;
	static {
		availableUsers = new ArrayList<User>();
		User user1 = new User("admin", "phoenix123");
		User user2 = new User("system", "kingfisher123");
		availableUsers.add(user1);
		availableUsers.add(user2);
	}
	public static List<User> getAvailableUsers(){
		return availableUsers;
	}
}
