package src.model;

import java.util.Random;

/**
 *
 * @author johnc
 * @version Fall 2020
 */
public class MainManager {
	private RestaurantManager restaurantManager;
	private ReviewManager reviewManager;
	private boolean resetFilters;

	/**
	 * @precondition none
	 * @postcondition none
	 * @param randomGenerator
	 */
	public MainManager(Random randomGenerator) {
		this.resetFilters = false;
		this.restaurantManager = new RestaurantManager(randomGenerator);
		this.reviewManager = new ReviewManager();
	}

	/**
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @return
	 */
	public RestaurantManager getRestaurantManager() {
		return this.restaurantManager;
	}

	/**
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @return
	 */
	public boolean getResetFilters() {
		return this.resetFilters;
	}

	/**
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @param resetFilters
	 */
	public void setResetFilters(boolean resetFilters) {
		this.resetFilters = resetFilters;
	}

	/**
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @return
	 */
	public ReviewManager getReviewManager() {
		return this.reviewManager;
	}
}
