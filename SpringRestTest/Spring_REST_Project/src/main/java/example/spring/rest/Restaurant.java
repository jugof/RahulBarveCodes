package example.spring.rest;

public class Restaurant {
	private int restaurantId;
	private String name;
	private String cuisine;
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
