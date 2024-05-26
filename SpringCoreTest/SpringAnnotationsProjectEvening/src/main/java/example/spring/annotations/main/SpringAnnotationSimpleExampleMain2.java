package example.spring.annotations.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import example.spring.annotations.beans.GreetingService;
import example.spring.annotations.config.SpringConfig;

public class SpringAnnotationSimpleExampleMain2 {

	public static void main(String[] args) {
		Class<SpringConfig> configuationUnit = 
				SpringConfig.class;
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(configuationUnit);
		//The above statement handles registration and refresh implicitly.
				
		Object loadedObject = ctx.getBean("userBean");
		GreetingService gs = (GreetingService)loadedObject;
		String reply = gs.sayGreeting();
		System.out.println(reply);

	}

}
