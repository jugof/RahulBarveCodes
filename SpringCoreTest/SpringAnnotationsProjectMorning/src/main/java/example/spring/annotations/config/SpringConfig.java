package example.spring.annotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import example.spring.annotations.beans.GreetingService;
import example.spring.annotations.beans.HelloService;
import example.spring.annotations.beans.UserService;
import example.spring.annotations.beans.WelcomeService;

@Configuration//Marks this class as a Configuration Unit
public class SpringConfig {
	//Configuring a bean of type: HelloService
	@Bean//Marks this method as a Bean Configuration method.
	public GreetingService hello() {
		GreetingService hs = new HelloService();
		return hs;
	}
	@Bean
	public GreetingService welcome() {
		GreetingService ws = new WelcomeService();
		return ws;
	}
	
	@Bean("userBean")
	public GreetingService user() {
		GreetingService us = new UserService("Sameer", 26);
		return us;
	}
	
	@Bean("userBean2")
	@Lazy //Loads this bean lazily
	public GreetingService user2() {
		GreetingService us = new UserService("Swati", 36);
		return us;
	}
	
	@Bean("userBean3")
	@Scope("prototype")//Changing the scope to prototype
	public GreetingService user3() {
		GreetingService us = new UserService("Ashish", 46);
		return us;
	}
}
