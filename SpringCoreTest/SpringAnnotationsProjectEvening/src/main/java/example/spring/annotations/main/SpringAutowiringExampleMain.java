package example.spring.annotations.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import example.spring.annotations.config.SpringAutowiringConfig;

public class SpringAutowiringExampleMain {
	public static void main(String[] args) {
		Class<SpringAutowiringConfig> configClass = 
				SpringAutowiringConfig.class;
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(configClass);
		Object customerObj = ctx.getBean("myCustomer");
		System.out.println(customerObj);
	}
}
