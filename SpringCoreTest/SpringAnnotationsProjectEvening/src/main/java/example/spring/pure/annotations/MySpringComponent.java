package example.spring.pure.annotations;

import org.springframework.stereotype.Component;

@Component//Marks this class as a Component (Managed Component)
public class MySpringComponent {
	public void doWork() {
		System.out.println("My Spring Component works...");
	}
}
