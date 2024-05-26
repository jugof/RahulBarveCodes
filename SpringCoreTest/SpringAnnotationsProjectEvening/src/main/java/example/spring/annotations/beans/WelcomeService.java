package example.spring.annotations.beans;

public class WelcomeService implements GreetingService {

	@Override
	public String sayGreeting() {
		// TODO Auto-generated method stub
		return "Welcome from Spring Annotations";
	}

}
