package example.spring.annotations.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import example.spring.annotations.beans.GreetingService;
import example.spring.annotations.config.SpringConfig;

public class SpringAnnotationSimpleExampleMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext();
		
		Class<SpringConfig> configuationUnit = 
				SpringConfig.class;
		ctx.register(configuationUnit);
		//Refreshing the context to apply changes.
		ctx.refresh();
		
		Object loadedObject = ctx.getBean("welcome");
		GreetingService gs = (GreetingService)loadedObject;
		String reply = gs.sayGreeting();
		System.out.println(reply);

	}

}
