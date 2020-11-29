package src.model;

import java.util.List;
import java.util.Random;

public class MainManager {
	private RestaurantManager restaurantManager;
	private ReviewManager reviewManager;
	private boolean resetFilters;

	public MainManager(Random randomGenerator) {
		this.resetFilters = false;
		this.restaurantManager = new RestaurantManager(randomGenerator);
		this.reviewManager = new ReviewManager();
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

	public ReviewManager getReviewManager() {
		return this.reviewManager;
	}
}
