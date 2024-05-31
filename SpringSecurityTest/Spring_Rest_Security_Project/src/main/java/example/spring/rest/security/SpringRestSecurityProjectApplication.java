package example.spring.rest.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableWebSecurity//Enables security customization done using SecurityFilterChain

public class SpringRestSecurityProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestSecurityProjectApplication.class, args);
	}
	@Bean
	public UserDetailsService getUserDetailsService() {
		UserDetails adminUser = 
				User.withUsername("admin").password("{noop}phoenix123").roles("ADMIN").build();
		UserDetails regularUser = 
				User.withUsername("regular").password("{noop}phoenix123").roles("USER").build();
		InMemoryUserDetailsManager userDetailsManager = 
				new InMemoryUserDetailsManager(adminUser, regularUser);
		return userDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> {
					auth.requestMatchers("/do-greet").permitAll();
					auth.requestMatchers("/do-regular-work").hasAnyRole("ADMIN", "USER").
					requestMatchers("/do-admin-work").hasAnyRole("ADMIN").anyRequest().authenticated();
				}
		);
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}


}
