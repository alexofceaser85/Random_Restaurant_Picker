package src.model;

import java.util.Random;

/**
<<<<<<< HEAD
 * Houses both the restaurant and review managers.
=======
 * The main manager for the application, holds the restaurant and review managers and the boolean to reset the filters
 * 
>>>>>>> branch 'master' of https://github.com/alexofceaser85/CS3211_Project_Four.git
 * @author johnc
 * @version Fall 2020
 */

public class MainManager {
	private RestaurantManager restaurantManager;
	private ReviewManager reviewManager;
	private boolean resetFilters;

	/**
<<<<<<< HEAD
	 * One-parameter constructor.
=======
	 * the constructor for the main manager
	 * 
	 * @param randomGenerator the random generater to get a random restaurant for
	 * 
>>>>>>> branch 'master' of https://github.com/alexofceaser85/CS3211_Project_Four.git
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
<<<<<<< HEAD
	 * Gets the restaurant manager.
=======
	 * The getter for the restaurant manager
	 * 
>>>>>>> branch 'master' of https://github.com/alexofceaser85/CS3211_Project_Four.git
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the restaurant manager
	 */
	public RestaurantManager getRestaurantManager() {
		return this.restaurantManager;
	}

	/**
<<<<<<< HEAD
	 * Gets the reset filters determination.
=======
	 * the getter for the reset filters boolean
	 * 
>>>>>>> branch 'master' of https://github.com/alexofceaser85/CS3211_Project_Four.git
	 * @precondition none
	 * @postcondition none
	 *
<<<<<<< HEAD
	 * @return the reset filters determination
=======
	 * @return the reset filters boolean
>>>>>>> branch 'master' of https://github.com/alexofceaser85/CS3211_Project_Four.git
	 */
	public boolean getResetFilters() {
		return this.resetFilters;
	}

	/**
<<<<<<< HEAD
	 * Sets the determination of resetting the filters.
=======
	 * The setter for the reset filters boolean
	 * 
>>>>>>> branch 'master' of https://github.com/alexofceaser85/CS3211_Project_Four.git
	 * @precondition none
	 * @postcondition this.resetFilters == resetFilters
	 *
<<<<<<< HEAD
	 * @param resetFilters the value to be set
=======
	 * @param resetFilters the value to set the reset filters
>>>>>>> branch 'master' of https://github.com/alexofceaser85/CS3211_Project_Four.git
	 */
	public void setResetFilters(boolean resetFilters) {
		this.resetFilters = resetFilters;
	}

	/**
<<<<<<< HEAD
	 * Gets the review manager.
=======
	 * The getter for the review manager
	 * 
>>>>>>> branch 'master' of https://github.com/alexofceaser85/CS3211_Project_Four.git
	 * @precondition none
	 * @postconditon none
	 *
	 * @return the review manager
	 */
	public ReviewManager getReviewManager() {
		return this.reviewManager;
	}
}
