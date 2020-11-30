package src.model;

import java.util.Random;

/**
 * The main manager for the application, holds the restaurant and review managers and the boolean to reset the filters
 * 
 * @author johnc
 * @version Fall 2020
 */

public class MainManager {
	private RestaurantManager restaurantManager;
	private ReviewManager reviewManager;
	private boolean resetFilters;

	/**
	 * the constructor for the main manager
	 * 
	 * @param randomGenerator the random generater to get a random restaurant for
	 * 
	 * @precondition none
	 * @postcondition 
	 * 		this.resetFilters == false
	 * 		this.restaurantManager == RestaurantManager(randomGenerator)
	 * 		this.reviewManager == ReviewManager
	 */
	public MainManager(Random randomGenerator) {
		this.resetFilters = false;
		this.restaurantManager = new RestaurantManager(randomGenerator);
		this.reviewManager = new ReviewManager();
	}

	/**
	 * The getter for the restaurant manager
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the restaurant manager
	 */
	public RestaurantManager getRestaurantManager() {
		return this.restaurantManager;
	}

	/**
	 * the getter for the reset filters boolean
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the reset filters boolean
	 */
	public boolean getResetFilters() {
		return this.resetFilters;
	}

	/**
	 * The setter for the reset filters boolean
	 * 
	 * @precondition none
	 * @postcondition this.resetFilters == resetFilters
	 *
	 * @param resetFilters the value to set the reset filters
	 */
	public void setResetFilters(boolean resetFilters) {
		this.resetFilters = resetFilters;
	}

	/**
	 * The getter for the review manager
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @return the review manager
	 */
	public ReviewManager getReviewManager() {
		return this.reviewManager;
	}
}
