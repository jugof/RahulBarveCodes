package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringSimpleExampleMain {

	public static void main(String[] args) {
		// Program that makes a request to Spring for
		//getting the bean of which ID is 'greet'
		//by looking into the configuration unit:
		//spring-config.xml located under:
		//src/main/resources
		
		//Building the ApplicationContext
		String configLocation = 
				"./src/main/resources/spring-config.xml";
		ApplicationContext ctx = 
				new FileSystemXmlApplicationContext(configLocation);
		
		//Obtaining the bean of which the ID is greet using that context
		Object loadedObject = ctx.getBean("greet");
		GreetingService gs = (GreetingService)loadedObject;
		String reply = gs.sayGreeting();
		System.out.println(reply);
		
		//Obtaining the bean of which the ID is greet2 using that context
		loadedObject = ctx.getBean("greet2");
		gs = (GreetingService)loadedObject;
		reply = gs.sayGreeting();
		System.out.println(reply);
	}

}
