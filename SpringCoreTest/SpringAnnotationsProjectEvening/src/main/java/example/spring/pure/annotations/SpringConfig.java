package example.spring.pure.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan//Asks spring to perform Component scanning
@ComponentScan(basePackages = {"food_item", "example"})
public class SpringConfig {
	//@Bean declarations if any
	
	//Some bean configurations as per the requirement
}
