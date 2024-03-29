package src.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import src.error_messages.ErrorMessages;

/**
 * The class responsible for holding and managing the restaurants
 * 
 * @author Alex DeCesare
 * @version Fall 2020
 **/

public class RestaurantManager {

	private List<Restaurant> theRestaurants;
	private Random randomGenerator;

	/**
	 * The constructor for the Restaurant Manager.
	 * 
	 * @param randomGenerator the Random object
	 * 
	 * @precondition none
	 * @postcondition none
	 */

	public RestaurantManager(Random randomGenerator) {
		this.theRestaurants = new ArrayList<Restaurant>();
		this.randomGenerator = randomGenerator != null ? randomGenerator : new Random();
	}

	/**
	 * Adds a restaurant to the Restaurant Manager.
	 * 
	 * @precondition restaurantToAdd != null
	 * @postcondition theRestaurants.size() == theRestaurants.size() + 1
	 * 
	 * @param restaurantToAdd the restaurant to add to the manager.
	 */

	public void addRestaurant(Restaurant restaurantToAdd) {

		if (restaurantToAdd == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_TO_ADD_CANNOT_BE_NULL);
		}

		this.theRestaurants.add(restaurantToAdd);

	}

	/**
	 * Removes a restaurant from the restaurant manager.
	 * 
	 * @precondition restaurantToRemove != null
	 * @postcondition theRestaurants.size() == theRestaurants.size() - 1
	 * 
	 * @param restaurantToRemove the restaurant to remove from the manager.
	 */

	public void removeRestaurant(Restaurant restaurantToRemove) {

		if (restaurantToRemove == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_TO_REMOVE_CANNOT_BE_NULL);
		}

		this.theRestaurants.remove(restaurantToRemove);

	}

	/**
	 * Gets the number of restaurants in the restaurant manager.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of restaurants in the restaurant manager
	 */

	public int size() {
		return this.theRestaurants.size();
	}

	/**
	 * returns a string representation of the Restaurant Manager object
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return restaurantManagerString the string representation of the object
	 */

	@Override
	public String toString() {

		String restaurantManagerString = "";

		for (Restaurant theRestaurant : this.theRestaurants) {
			restaurantManagerString += theRestaurant.toString() + System.lineSeparator();
		}

		return restaurantManagerString;
	}

	/**
	 * Picks a random restaurant using randomGenerator
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return a random Restaurant
	 */
	public Restaurant pickRandom() {
		if (this.theRestaurants.isEmpty()) {
			return null;
		}
		int randomIndex = this.randomGenerator.nextInt(this.theRestaurants.size());
		return this.theRestaurants.get(randomIndex);
	}

	/**
	 * Sets the restaurants list if restaurants is not null.
	 * 
	 * @precondition theRestaurants != null
	 * @postcondition this.theRestaurants == theRestaurants
	 *
	 * @param theRestaurants restaurants to be set.
	 */
	public void setTheRestaurants(List<Restaurant> theRestaurants) {
		if (theRestaurants == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANTS_TO_SET_CANNOT_BE_NULL);
		}
		this.theRestaurants = theRestaurants;
	}

}
