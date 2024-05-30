package restaurant_api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import restaurant_api.entity.Restaurant;
import restaurant_api.service.RestaurantService;
@RestController
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantServiceRef;
	
	//@RequestMapping("/restaurant-data-api")
	@GetMapping("/restaurant-data-api")
	public Collection<Restaurant> getAllRestaurants(){
		Collection<Restaurant> allRestaurants = 
		restaurantServiceRef.getAllRestaurants();
		return allRestaurants;
	}
	
	//@RequestMapping("/restaurant-data-api/{restId}")
	@GetMapping("/restaurant-data-api/{restId}")
	public Restaurant getOneRestaurant(@PathVariable("restId") Integer id) {
		Restaurant foundRestaurant =
				restaurantServiceRef.getOneRestaurant(id);
		return foundRestaurant;
	}
	
	//@RequestMapping(value = "/restaurant-data-api", method = RequestMethod.POST)
	@PostMapping("/restaurant-data-api")
	public void addNewRestaurant(@RequestBody Restaurant restaurantObj) {
		System.out.println(restaurantObj);
		restaurantServiceRef.addNewRestaurant(restaurantObj);
	}
	
}
