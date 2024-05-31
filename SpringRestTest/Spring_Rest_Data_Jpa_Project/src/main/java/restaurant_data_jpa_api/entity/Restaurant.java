package restaurant_data_jpa_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurant_master")
public class Restaurant {
	@Id
	@Column(name = "restaurant_id")
	private int restaurantId;
	@Column(name = "restaurant_name")
	private String name;
	@Column(name = "restaurant_cuisine")
	private String cuisine;
	@Column(name = "restaurant_branch_count")
	private int branchCount;
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}
	public Restaurant(int restaurantId, String name, String cuisine, int branchCount) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisine = cuisine;
		this.branchCount = branchCount;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public int getBranchCount() {
		return branchCount;
	}
	public void setBranchCount(int branchCount) {
		this.branchCount = branchCount;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", cuisine=" + cuisine + ", branchCount="
				+ branchCount + "]";
	}
	

}
