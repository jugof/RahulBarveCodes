package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSimpleExampleMain2 {

	public static void main(String[] args) {
		// This program uses ClassPathXmlApplicationContext
		String fileName = "spring-config.xml";
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext(fileName);
		Object obj = ctx.getBean("greet");
		GreetingService gs = (GreetingService)obj;
		System.out.println(gs.sayGreeting());

	}

}
