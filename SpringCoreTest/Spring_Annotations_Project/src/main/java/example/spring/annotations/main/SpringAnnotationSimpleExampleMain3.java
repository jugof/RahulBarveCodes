package example.spring.annotations.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import example.spring.annotations.beans.GreetingService;
import example.spring.annotations.config.SpringConfig;

public class SpringAnnotationSimpleExampleMain3 {

	public static void main(String[] args) {
		Class<SpringConfig> configuationUnit = 
				SpringConfig.class;
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(configuationUnit);
		
				
		Object obj  = ctx.getBean("userBean2");
		Object obj2 = ctx.getBean("userBean2");
		System.out.println(obj == obj2);
		
		obj  = ctx.getBean("userBean3");
		obj2 = ctx.getBean("userBean3");
		System.out.println(obj == obj2);
		
		

	}

}
