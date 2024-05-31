package restaurant_data_jpa_api.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant_data_jpa_api.entity.Restaurant;
import restaurant_data_jpa_api.repository.RestaurantRepository;
@Service//Marks this class as a Service
public class RestaurantService {
	@Autowired //Injecting Repository into Service
	private RestaurantRepository restaurantRepositoryRef;
	
	public Collection<Restaurant> getAllRestaurants(){
		Collection<Restaurant> allRestaurants = 
		restaurantRepositoryRef.findAll();
		return allRestaurants;
	}
	public Restaurant getOneRestaurant(Integer id) {
		Restaurant foundRestaurant = null;
		Optional<Restaurant> restaurantOpt = 
				restaurantRepositoryRef.findById(id);
		if(restaurantOpt.isPresent()) {
			foundRestaurant = restaurantOpt.get();
		}
		return foundRestaurant;
	}
	public void addNewRestaurant(Restaurant restaurantObj) {
		restaurantRepositoryRef.save(restaurantObj);
	}
	
	public void deleteRestaurantById(Integer id) {
		restaurantRepositoryRef.deleteById(id);
	}
}






