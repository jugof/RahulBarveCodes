package restaurant_api.repository;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import restaurant_api.entity.Restaurant;
import restaurant_api.storage.RestaurantStorage;

@Repository//Marks this class as a Repository
public class RestaurantRepository {
	//This class interacts with RestaurantStorage to perform CRUD operations
	public Collection<Restaurant> getAllRestaurants(){
		Collection<Restaurant> allRestaurants = 
		RestaurantStorage.getAllRestaurants();
		return allRestaurants;
	}
}
