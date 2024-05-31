package restaurant_data_jpa_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant_data_jpa_api.entity.Restaurant;
//@Repository is not required because JpaRepository is already a Managed Component
//and therefore its sub-interface: RestaurantRepository also becomes a Managed Component
public interface RestaurantRepository 
	extends JpaRepository<Restaurant, Integer>{}








