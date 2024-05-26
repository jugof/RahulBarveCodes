package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionExampleMain {

	public static void main(String[] args) {
		String configFile = "spring-config.xml";
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext(configFile);
		GreetingService gs = 
				(GreetingService)ctx.getBean("userBean");
		String reply = gs.sayGreeting();
		System.out.println(reply);
		
		gs = (GreetingService)ctx.getBean("userBean2");
		reply = gs.sayGreeting();
		System.out.println(reply);
		
		gs = (GreetingService)ctx.getBean("userBean3");
		reply = gs.sayGreeting();
		System.out.println(reply);
		
		gs = (GreetingService)ctx.getBean("userBean4");
		reply = gs.sayGreeting();
		System.out.println(reply);


	}

}
