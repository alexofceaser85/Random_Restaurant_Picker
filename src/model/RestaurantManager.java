package src.model;

import java.util.ArrayList;
import java.util.List;

import src.error_messages.ErrorMessages;

/**
 * The class responsible for holding and managing the restaurants
 * 
 * @author Alex DeCesare
 * @version 20-November-2020
 **/

public class RestaurantManager {
	
	private List<Restaurant> theRestaurants;
	
	/**
	 * The constructor for the Restaurant Manager
	 * 
	 * @precondition none
	 * @postcondition none
	 */
	
	public RestaurantManager() {
		this.theRestaurants = new ArrayList<Restaurant>();
	}
	
	/**
	 * Adds a restaurant to the Restaurant Manager
	 * 
	 * @precondition restaurantToAdd != null
	 * @postcondition theRestaurants.size() == theRestaurants.size() + 1
	 * 
	 * @param restaurantToAdd the restaurant to add to the manager
	 */
	
	public void addRestaurant(Restaurant restaurantToAdd) {
		
		if(restaurantToAdd == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_TO_ADD_CANNOT_BE_NULL);
		}

		this.theRestaurants.add(restaurantToAdd);
		
	}
	
	/**
	 * Removes a restaurant from the restaurant manager
	 * 
	 * @precondition restaurantToRemove != null
	 * @postcondition theRestaurants.size() == theRestaurants.size() - 1
	 * 
	 * @param restaurantToRemove the restaurant to remove from the manager
	 * 
	 * @return True if the restaurant is removed and False if it is not removed
	 */
	
	public void removeRestaurant(Restaurant restaurantToRemove) {
		
		if(restaurantToRemove == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_TO_REMOVE_CANNOT_BE_NULL);
		}
		
		this.theRestaurants.remove(restaurantToRemove);
		
	}
	
	/**
	 * Gets the number of restaurants in the restaurant manager
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the number of restaurants in the restaurant manager
	 */

	public int size() {
		return theRestaurants.size();
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
		
		for (Restaurant theRestaurant : theRestaurants) {
			restaurantManagerString += theRestaurant.toString() + System.lineSeparator();
		}
		
		return restaurantManagerString;
	}

}
