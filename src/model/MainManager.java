package src.model;

import java.util.Random;

/**
 * Houses both the restaurant and review managers.
 * The main manager for the application, holds the restaurant and review managers and the boolean to reset the filters
 * 
 * @author Furichous Jones IV
 * @version Fall 2020
 */

public class MainManager {
	private RestaurantManager restaurantManager;
	private ReviewManager reviewManager;
	private boolean resetFilters;

	/**
	 * One-parameter constructor.
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
	 * Gets the restaurant manager.
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
	 * Gets the reset filters determination.
	 * the getter for the reset filters boolean
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the reset filters determination
	 */
	public boolean getResetFilters() {
		return this.resetFilters;
	}

	/**
	 * Sets the determination of resetting the filters.
	 * The setter for the reset filters boolean
	 * 
	 * @precondition none
	 * @postcondition this.resetFilters == resetFilters
	 *
	 * @param resetFilters the value to be set
	 */
	public void setResetFilters(boolean resetFilters) {
		this.resetFilters = resetFilters;
	}

	/**
	 * Gets the review manager.
	 * The getter for the review manager
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the review manager
	 */
	public ReviewManager getReviewManager() {
		return this.reviewManager;
	}
	
	/**
	 * Removes a restaurant from the manager
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @param theRestaurant the restaurant to remove
	 */
	
	public void removeRestaurant(Restaurant theRestaurant) {
		this.restaurantManager.removeRestaurant(theRestaurant);
	}
}
