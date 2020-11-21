package src.model;

public class MainManager {
	private RestaurantManager restaurantManager;
	private boolean resetFilters;
	public MainManager() {
		this.resetFilters = false;
		this.restaurantManager = new RestaurantManager();
	}
	
	public RestaurantManager getRestaurantManager() {
		return this.restaurantManager;
	}
	
	public boolean getResetFilters() {
		return this.resetFilters;
	}
	
	public void setResetFilters(boolean resetFilters) {
		this.resetFilters = resetFilters;
	}
}
