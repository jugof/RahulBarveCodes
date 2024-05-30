package example.spring.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Marks this class as a REST Controller
public class SpringRestController {
	@RequestMapping("/say-hello")
	public String greet() {
		return "Welcome ALL!! from Spring REST";		
	}
	
	@RequestMapping("/one-restaurant")
	public Restaurant getOneRestaurant() {
		Restaurant rst = 
				new Restaurant(101, "McDonalds", "American", 10);
		return rst;
	}
	
	@RequestMapping("/all-restaurants")
	public Collection<Restaurant> getAllRestaurants(){
		Restaurant rst = new Restaurant(101, "McDonalds", "American", 10);
		Restaurant rst2 = new Restaurant(102, "Kamat", "Indian", 25);
		Restaurant rst3 = new Restaurant(103, "Little Italy", "Italian", 15);
		Restaurant rst4 = new Restaurant(104, "Mamagoto", "Asian", 15);
		
		List<Restaurant> allRestaurants =
		List.of(rst, rst2, rst3, rst4);
		
		return allRestaurants;
	}
	

}
