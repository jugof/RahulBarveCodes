package example.spring.annotations.beans;

public class HelloService implements GreetingService {

	@Override
	public String sayGreeting() {
		// TODO Auto-generated method stub
		return "Hello from Spring Annotations.";
	}

}
