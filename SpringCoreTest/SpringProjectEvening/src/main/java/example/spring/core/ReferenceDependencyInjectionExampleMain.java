package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReferenceDependencyInjectionExampleMain {

	public static void main(String[] args) {
		String configFile = "spring-config2.xml";
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext(configFile);
		Object customerObject = ctx.getBean("customerBean");
		System.out.println(customerObject);

	}

}
