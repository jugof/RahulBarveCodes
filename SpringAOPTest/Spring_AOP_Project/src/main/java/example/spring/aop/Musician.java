package example.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Musician {
	public void perform() {
		System.out.println("Playing a Guitar");
		//throw new RuntimeException();
	}
}
