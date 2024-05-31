package example.spring.rest.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityRestController {
	@GetMapping("/do-greet")
	public String greet() {
		return "Welcome to Spring Security";
	}
	@GetMapping("/do-admin-work")
	public String doAdminWork() {
		return "Administrator doing some Admin Work";
	}
	@GetMapping("/do-regular-work")
	public String doRegularWork() {
		return "Regular User doing some Regular Work";
	}
}
