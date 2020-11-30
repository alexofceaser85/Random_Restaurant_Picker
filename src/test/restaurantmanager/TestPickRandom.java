/**
 * 
 */
package src.test.restaurantmanager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import src.model.Price;
import src.model.Restaurant;
import src.model.RestaurantManager;

/**
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
class TestPickRandom {

	public class FakeRandom extends Random {
		private static final long serialVersionUID = 1L;
		private int expected;

		public FakeRandom(int expected) {
			this.expected = expected;
		}

		@Override
		public int nextInt(int max) {
			return expected;
		}
	}

	@Test
	void testEmptyRestaurants() {
		RestaurantManager testRestaurantManager = new RestaurantManager(new FakeRandom(0));

		Restaurant pickedRestaurant = testRestaurantManager.pickRandom();
		assertNull(pickedRestaurant);
	}

	@Test
	void testOneRestaurants() {
		RestaurantManager testRestaurantManager = new RestaurantManager(new FakeRandom(0));
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8,
				"First Menu URL", "First Image URL", "5416");

		testRestaurantManager.addRestaurant(theFirstRestaurant);
		Restaurant pickedRestaurant = testRestaurantManager.pickRandom();

		assertEquals(
				"Name: First Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416",
				pickedRestaurant.toString());
	}

	@Test
	void testManyRestaurants() {
		RestaurantManager testRestaurantManager = new RestaurantManager(new FakeRandom(1));
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8,
				"First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", Price.$, "Atlanta, GA, USA", 15, 3.9,
				"Second Menu URL", "Second Image URL", "41987");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", Price.$, "Atlanta, GA, USA", 10, 4.5,
				"Third Menu URL", "Third Image URL", "4561");

		testRestaurantManager.addRestaurant(theFirstRestaurant);
		testRestaurantManager.addRestaurant(theSecondRestaurant);
		testRestaurantManager.addRestaurant(theThirdRestaurant);
		Restaurant pickedRestaurant = testRestaurantManager.pickRandom();

		assertEquals(
				"Name: Second Restaurant Price: $ Location: Atlanta, GA, USA Distance: 15 Review Score: 3.9 Menu URL: Second Menu URL Image URL: Second Image URL Id: 41987",
				pickedRestaurant.toString());
	}

}
