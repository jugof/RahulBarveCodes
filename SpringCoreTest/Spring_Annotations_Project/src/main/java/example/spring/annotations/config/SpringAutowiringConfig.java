package example.spring.annotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import example.spring.annotations.beans.Address;
import example.spring.annotations.beans.Customer;

@Configuration
public class SpringAutowiringConfig {
	@Bean("myAddress")
	//@Primary
	public Address address() {
		Address addr = new Address("Pune", 411038);
		return addr;
	}
	
	@Bean("myAddress2")	
	public Address address2() {
		Address addr = new Address("Mumbai", 422001);
		return addr;
	}
	
	@Bean("myCustomer")
	public Customer customer() {
		Customer c1 = new Customer();
		c1.setId("C01");
		c1.setName("Rakesh");
		//Not setting value for Permanent Address.
		//Asking Spring to auto-wire it.
		return c1;
	}
}
