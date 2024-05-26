package example.spring.core;

public class UserService implements GreetingService {
	private String userName;
	private int age;
	
	public UserService() {
		System.out.println("Inside UserService()");
	}

	public UserService(String userName, int age) {
		System.out.println("Inside UserService(String, int)");
		this.userName = userName;
		this.age = age;
	}

	public UserService(int age, String userName) {
		System.out.println("Inside UserService(int, String)");
		this.age = age;
		this.userName = userName;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("Setting userName");
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("Setting age");
		this.age = age;
	}

	@Override
	public String sayGreeting() {
		// TODO Auto-generated method stub
		String greeting = 
		"Hey " + userName + ", your age is " + age + " years";
		return greeting;
	}

}
