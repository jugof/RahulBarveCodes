package example.spring.mvc.model;

import java.util.List;

public class UserValidator {
	public static boolean isValid(User currentUser) {
		List<User> existingUsersList = 
				UserRepository.getAvailableUsers();
		boolean found = false;
		for(User existingUser : existingUsersList) {
			if(currentUser.equals(existingUser)) {
				found = true;
				break;
			}
		}
		return found;
	}
}
