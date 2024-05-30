package restaurant_api.storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import restaurant_api.entity.Restaurant;

public class RestaurantStorage {
	//This class maintains In-Memory storage of Restaurants
	private static Map<Integer, Restaurant> restaurantMap;
	
	static {
		restaurantMap = new HashMap<>();
		Restaurant rst = new Restaurant(3245, "KFC", "American", 10);
		Restaurant rst2 = new Restaurant(455, "Kamat", "Indian", 25);
		Restaurant rst3 = new Restaurant(1233, "Little Italy", "Italian", 15);
		Restaurant rst4 = new Restaurant(44, "Mamagoto", "Asian", 15);
		
		restaurantMap.put(rst.getRestaurantId(), rst);
		restaurantMap.put(rst2.getRestaurantId(), rst2);
		restaurantMap.put(rst3.getRestaurantId(), rst3);
		restaurantMap.put(rst4.getRestaurantId(), rst4);	
	}
	
	//Method to return all the restaurants
	public static Collection<Restaurant> getAllRestaurants(){
		Collection<Restaurant> allAvailableRestaurants = 
				restaurantMap.values();	
		return allAvailableRestaurants;
	}
}
