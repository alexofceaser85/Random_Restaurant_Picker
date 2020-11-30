package src.model;

import java.util.Random;

/**
 * Houses both the restaurant and review managers.
 * @author johnc
 * @version Fall 2020
 */
public class MainManager {
	private RestaurantManager restaurantManager;
	private ReviewManager reviewManager;
	private boolean resetFilters;

	/**
	 * One-parameter constructor.
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
	 * Gets the restaurant manager.
	 * @precondition none
	 * @postconditon none
	 *
	 * @return the restaurant manager
	 */
	public RestaurantManager getRestaurantManager() {
		return this.restaurantManager;
	}

	/**
	 * Gets the reset filters determination.
	 * @precondition none
	 * @postconditon none
	 *
	 * @return the reset filters determination
	 */
	public boolean getResetFilters() {
		return this.resetFilters;
	}

	/**
	 * Sets the determination of resetting the filters.
	 * @precondition none
	 * @postconditon none
	 *
	 * @param resetFilters the value to be set
	 */
	public void setResetFilters(boolean resetFilters) {
		this.resetFilters = resetFilters;
	}

	/**
	 * Gets the review manager.
	 * @precondition none
	 * @postconditon none
	 *
	 * @return the review manager
	 */
	public ReviewManager getReviewManager() {
		return this.reviewManager;
	}
}
