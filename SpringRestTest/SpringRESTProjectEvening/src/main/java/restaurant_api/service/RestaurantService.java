package restaurant_api.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant_api.entity.Restaurant;
import restaurant_api.repository.RestaurantRepository;

@Service//Marks this class as a Service
public class RestaurantService {
	@Autowired //Injecting Repository into Service
	private RestaurantRepository restaurantRepositoryRef;
	
	public Collection<Restaurant> getAllRestaurants(){
		Collection<Restaurant> allRestaurants = 
		restaurantRepositoryRef.getAllRestaurants();
		return allRestaurants;
	}
	public Restaurant getOneRestaurant(Integer id) {
		Restaurant foundRestaurant = 
				restaurantRepositoryRef.getOneRestaurant(id);
		return foundRestaurant;
	}
	public void addNewRestaurant(Restaurant restaurantObj) {
		restaurantRepositoryRef.addNewRestaurant(restaurantObj);
	}
}
