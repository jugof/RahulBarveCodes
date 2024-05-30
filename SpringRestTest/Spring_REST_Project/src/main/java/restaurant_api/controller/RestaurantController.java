package restaurant_api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restaurant_api.entity.Restaurant;
import restaurant_api.service.RestaurantService;
@RestController
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantServiceRef;
	
	@RequestMapping("/restaurant-data-api")
	public Collection<Restaurant> getAllRestaurants(){
		Collection<Restaurant> allRestaurants = 
		restaurantServiceRef.getAllRestaurants();
		return allRestaurants;
	}
}
